package cn.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;

import cn.app.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    
	//用户业务类
	@Resource
	public UserService userService;

	@RequestMapping(value = "/klogin")
	public String klogin() {
		return "klogin";
	}

	@RequestMapping(value = "/hlogin")
	public String hlogin() {
		return "hlogin";
	}
	// @RequestMapping(value="/index")
	// public String index(){
	// return "/dev/index";
	// }
	
    //开发用户登陆Action
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String dologin(@RequestParam("devCode") String devCode, @RequestParam("devPassword") String devPassword,
			HttpSession session) {

		DevUser devuser = userService.userLogin(devCode, devPassword);
		System.out.println(devuser.getDevName() + devuser.getDevPassword());

		if (devuser != null) {
			session.setAttribute("devuser", devuser);
			return "/dev/index";  //用户存在跳转到主页面
		} else
			return "403";        //用户不存在

	}
	
	
	
	//管理员登陆Action
	@RequestMapping(value = "/adminlogin",method=RequestMethod.POST)
	public String adminlogin(@RequestParam("userCode") String userCode, @RequestParam("userPassword") String userPassword,
			HttpSession session){
		System.out.println(userCode+"null");
		BackendUser admin = userService.adminLogin(userCode, userPassword);
		
		if(admin != null){
			session.setAttribute("admin", admin);
			return "/dev/index";   //管理登陆成功，跳转到管理员页面
			
		}else
			return "403";          //管理员登陆失败
	}
	
	

}
