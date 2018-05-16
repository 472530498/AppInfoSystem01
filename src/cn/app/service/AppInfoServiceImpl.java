package cn.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.AppInfoMapper;
import cn.app.pojo.AppInfo;

@Service
public class AppInfoServiceImpl implements AppInfoService{

	@Resource
	 public AppInfoMapper appInfoMapper ;
	
	@Override
	public List<AppInfo> getAllApp(int Offset,int line) {
		// TODO Auto-generated method stub
		
		List<AppInfo> list = appInfoMapper.findAllApp(Offset,line);
		
		return list;
	}

}
