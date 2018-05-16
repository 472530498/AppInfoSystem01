package cn.app.dao;

import java.util.List;

import cn.app.pojo.AppInfo;

public interface AppInfoMapper {
	
	public List<AppInfo> findAllApp(int Offset,int line);

}
