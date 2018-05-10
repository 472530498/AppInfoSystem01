package cn.app.dao;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.app.pojo.User;

public interface UserMapper {
	public User login(@Param("userName")String userName,@Param("password")String password);
 
}

