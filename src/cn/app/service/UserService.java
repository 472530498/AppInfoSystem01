package cn.app.service;

import org.springframework.stereotype.Service;

import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;

public interface UserService {
	/*
	 * 开发用户登录
	 * 
	 * @result:DevUser
	 * 
	 * @param:devCode,devPassword
	 */
	public DevUser userLogin(String devCode, String devPassword);

	/*
	 * 管理员登录
	 * 
	 * @result:BackendUser
	 * 
	 * @param:userCode,userPassword
	 */
	public BackendUser adminLogin(String userCode, String userPassword);

}
