package cn.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.DevUser;

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
	public String dologin(@RequestParam("devCode")String devCode,
						  @RequestParam("devPassword")String devPassword,
						  Model model){
		
		DevUser devuser=userService.userLogin(devCode,devPassword);
		System.out.println(devuser.getDevName()+devuser.getDevPassword());
		
		if(devuser!=null){
			model.addAttribute("devuser", devuser);
		return "/dev/index";
		}
		else return "403";		
		
	}

}
