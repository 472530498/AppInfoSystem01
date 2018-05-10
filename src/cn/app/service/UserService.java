package cn.app.service;

import org.springframework.stereotype.Service;

import cn.app.pojo.User;

public interface UserService {
	
	public User userLogin(String userName,String password);

}
