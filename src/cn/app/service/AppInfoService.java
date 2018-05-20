package cn.app.service;

import java.util.List;

import cn.app.pojo.AppInfo;
import cn.app.utils.PageSupport;

public interface AppInfoService {
	
	public PageSupport<AppInfo> getAllApp(Integer currentPageNo,Integer pageSize);

	public Integer deleteAppById(Integer id);



}
