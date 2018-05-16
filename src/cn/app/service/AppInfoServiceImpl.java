package cn.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.app.dao.AppInfoMapper;
import cn.app.pojo.AppInfo;
import cn.app.utils.PageSupport;

@Service
public class AppInfoServiceImpl implements AppInfoService{

	@Resource
	 public AppInfoMapper appInfoMapper ;
	
	@Override
	public PageSupport<AppInfo> getAllApp(Integer currentPageNo,Integer pageSize) {
		// TODO Auto-generated method stub
		
		PageSupport<AppInfo> pageList=new PageSupport<AppInfo>();
		List<AppInfo>list = appInfoMapper.findAllApp((currentPageNo-1)*pageSize,pageSize);
		pageList.setList(list);
		
		return pageList;
	}

}
