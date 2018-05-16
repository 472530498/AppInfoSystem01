package cn.app.dao;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cn.app.pojo.BackendUser;
import cn.app.pojo.DevUser;

public interface UserMapper {
	/*
	 * 开发用户登录
	 * 
	 * @result：DecUser
	 * 
	 * @param:devCode,devPassword
	 */
	public DevUser login(@Param("devCode") String devCode, @Param("devPassword") String devPassword);

	/*
	 * 管理员登录
	 * 
	 * @result:BackendUser
	 * 
	 * @param:userCode,userPassword
	 */
	public BackendUser adminLogin(@Param("userCode") String userCode, @Param("userPassword") String userPassword);

}
