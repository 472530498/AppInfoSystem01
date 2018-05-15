package cn.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.User;
import cn.app.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	public UserService userService;
	
	@RequestMapping(value="/klogin")
	public String klogin(){
		return "klogin";
	}
	@RequestMapping(value="/hlogin")
	public String hlogin(){
		return "hlogin";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String dologin(@RequestParam("userName")String userName,
						  @RequestParam("password")String password,
						  Model model){
		System.out.println(userName+password);
		User user=userService.userLogin(userName, password);
		System.out.println(user.getUserName()+user.getPassword());
		
		if(user!=null){
			model.addAttribute("user", user);
		return "dev/index";
		}
		else return "403";		
		
	}

}
