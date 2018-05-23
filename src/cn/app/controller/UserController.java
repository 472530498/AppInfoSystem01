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
    
	//鐢ㄦ埛涓氬姟绫�
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
	
    //寮�鍙戠敤鎴风櫥闄咥ction
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public String dologin(@RequestParam("devCode") String devCode, @RequestParam("devPassword") String devPassword,
			HttpSession session) {

		DevUser devuser = userService.userLogin(devCode, devPassword);
		System.out.println(devuser.getDevName() + devuser.getDevPassword());

		if (devuser != null) {
			session.setAttribute("devuser", devuser);
			return "/dev/index";  //鐢ㄦ埛瀛樺湪璺宠浆鍒颁富椤甸潰
		} else
			return "403";        //鐢ㄦ埛涓嶅瓨鍦�

	}
	
	
	
	//绠＄悊鍛樼櫥闄咥ction
	@RequestMapping(value = "/adminlogin",method=RequestMethod.POST)
	public String adminlogin(@RequestParam("userCode") String userCode, @RequestParam("userPassword") String userPassword,
			HttpSession session){
		System.out.println(userCode+"null");
		BackendUser admin = userService.adminLogin(userCode, userPassword);
		
		if(admin != null){
			session.setAttribute("admin", admin);
			return "/back/index";   //绠＄悊鐧婚檰鎴愬姛锛岃烦杞埌绠＄悊鍛橀〉闈�
			
		}else
			return "403";          //绠＄悊鍛樼櫥闄嗗け璐�
	}
	
	

}
