package cn.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.app.pojo.AppInfo;
import cn.app.utils.PageSupport;

public interface AppInfoMapper {

	public List<AppInfo> findAllApp(@Param("currentPageNo") Integer currentPageNo, @Param("pageSize") Integer pageSize);

	public Integer deleteAppById(@Param("id") Integer id);

}
