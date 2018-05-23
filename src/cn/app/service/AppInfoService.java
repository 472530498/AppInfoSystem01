package cn.app.service;

import java.util.List;

import cn.app.pojo.AppInfo;
import cn.app.utils.PageSupport;

public interface AppInfoService {
	
	public PageSupport<AppInfo> getAllApp(String softwareName,String interfaceLanguage,Integer currentPageNo,Integer pageSize);

	public Integer deleteAppById(Integer id);

    public Integer getAppNum(String softwareName,String interfaceLanguage);

	public void setAppStatus(Integer id, Integer status);




}
