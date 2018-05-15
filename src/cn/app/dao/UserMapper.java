package cn.app.dao;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.app.pojo.DevUser;

public interface UserMapper {
	public DevUser login(@Param("devCode")String devCode,@Param("devPassword")String devPassword);
 
}

