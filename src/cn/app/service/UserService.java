package cn.app.service;

import org.springframework.stereotype.Service;


import cn.app.pojo.DevUser;

public interface UserService {
	
	public DevUser userLogin(String userName,String password);

}
