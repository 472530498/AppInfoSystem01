package cn.app.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.app.dao.UserMapper;
import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	public UserMapper userMapper;

	@Override
	public DevUser userLogin(String devCode, String devPassword) {
		// TODO Auto-generated method stub
		DevUser devuser = userMapper.login(devCode, devPassword);

		return devuser;
	}

	@Override
	public BackendUser adminLogin(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		BackendUser admin = userMapper.adminLogin(userCode, userPassword);
		return admin;
	}

}
