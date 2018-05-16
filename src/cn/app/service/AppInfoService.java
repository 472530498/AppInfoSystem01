package cn.app.service;

import java.util.List;

import cn.app.pojo.AppInfo;

public interface AppInfoService {
	
	public List<AppInfo> getAllApp(int Offset,int line);

}
