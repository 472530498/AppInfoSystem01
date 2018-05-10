package cn.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.User;
import cn.app.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	public UserService userService;
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/dev")
	public String dev(){
		return "dev/index";
	}
	
	@RequestMapping(value="/dologin")
	public String dologin(@RequestParam("userName")String userName,
						  @RequestParam("password")String password,
						  Model model){
		System.out.println(userName+password);
		User user=userService.userLogin(userName, password);
		System.out.println(user.getUserName()+user.getPassword());
		
		if(user!=null)
		return "welcome";
		else return "403";		
		
	}

}
