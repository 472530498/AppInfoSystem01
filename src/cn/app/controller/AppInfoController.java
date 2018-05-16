package cn.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.AppInfo;
import cn.app.service.AppInfoService;
import cn.app.utils.PageSupport;

@Controller
public class AppInfoController {
	
	@Resource
	private AppInfoService appInfoService;
	
	 
	
	@RequestMapping(value="/selectappInfo")
	public String selectappInfo(@RequestParam("offset")int offset,@RequestParam("line")int line,Model model){
		System.out.println("controller:"+offset);
		System.out.println("controller:"+line);
		PageSupport<AppInfo> PageSupport =new PageSupport<AppInfo>();
		PageSupport.setCurrentPageNo(offset);
		PageSupport.setPageSize(line);
		PageSupport.setTotalCount(11);
		
		List<AppInfo> appinfolist=appInfoService.getAllApp(PageSupport.getCurrentPageNo(),PageSupport.getPageSize());
		PageSupport.setList(appinfolist);
		
		
//		System.out.println(PageSupport.getPageSize()+"/n");
//		System.out.println(PageSupport.getTotalCount()+"/n");
//		System.out.println(PageSupport.getCurrentPageNo()+"/n");
//		System.out.println(PageSupport.getList()+"/n");
		
		
		model.addAttribute("appinfolist", PageSupport.getList());
		return "/dev/index";
		
//		List<AppInfo> appinfolist=appInfoService.getAllApp();
//		for (AppInfo appInfo : appinfolist) {
//			System.out.println(appInfo.getSoftwareName());
//		}
//		model.addAttribute("appinfolist", appinfolist);
//		return "/dev/index";
	}

}
