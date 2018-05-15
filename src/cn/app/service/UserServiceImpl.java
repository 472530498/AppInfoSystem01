package cn.app.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.UserMapper;

import cn.app.pojo.DevUser;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	public UserMapper userMapper;
	
	@Override
	public DevUser userLogin(String userName, String password) {
		// TODO Auto-generated method stub
		DevUser user=userMapper.login(userName, password);
		
		return user;
	}

}
