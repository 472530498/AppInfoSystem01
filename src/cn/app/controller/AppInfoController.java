package cn.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.app.pojo.AppInfo;
import cn.app.service.AppInfoService;
import cn.app.utils.PageSupport;

@Controller
public class AppInfoController {

	@Resource
	private AppInfoService appInfoService;

	@RequestMapping(value = "/selectappInfo", method = RequestMethod.GET)
	public String selectappInfo(
			@RequestParam(value = "currentPageNo", required = false, defaultValue = "1") Integer currentPageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, 
			@RequestParam(value = "softwareName", required = false, defaultValue = "")String softwareName,
			@RequestParam(value = "interfaceLanguage", required = false, defaultValue = "")String interfaceLanguage,
			Model model) {
		PageSupport pagesupport = appInfoService.getAllApp(softwareName,interfaceLanguage,currentPageNo, pageSize);
		pagesupport.setPageSize(pageSize);
		pagesupport.setCurrentPageNo(currentPageNo);
		pagesupport.setTotalCount(appInfoService.getAppNum(softwareName,interfaceLanguage));

		model.addAttribute("pageSupport", pagesupport);
		return "/dev/appinfo";
	}
	@RequestMapping(value = "/selectappInfo", method = RequestMethod.POST)
	public String aselectappInfo(
			@RequestParam(value = "currentPageNo", required = false) Integer currentPageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "softwareName", required = false,defaultValue = "")String softwareName,
			@RequestParam(value = "interfaceLanguage", required = false,defaultValue = "")String interfaceLanguage,
			Model model) {
		PageSupport pagesupport = appInfoService.getAllApp(softwareName,interfaceLanguage,currentPageNo, pageSize);
		pagesupport.setPageSize(pageSize);
		pagesupport.setCurrentPageNo(currentPageNo);
		pagesupport.setTotalCount(appInfoService.getAppNum(softwareName,interfaceLanguage));

		model.addAttribute("pageSupport", pagesupport);
		return "/dev/appinfo";
	}
	
	
	@RequestMapping(value = "/deleteappInfo", method = RequestMethod.POST)
	public String deleteappInfo(
			@RequestParam(value = "currentPageNo", required = false) Integer currentPageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "softwateName", required =false) String softwateName,
			@RequestParam(value = "interfaceLanguage", required = false)String interfaceLanguage,
			Model model) {
			try{
				PageSupport pagesupport=new PageSupport<AppInfo>();
				appInfoService.deleteAppById(id);
				pagesupport= appInfoService.getAllApp(softwateName,interfaceLanguage,currentPageNo, pageSize);
				pagesupport.setPageSize(2);
				pagesupport.setCurrentPageNo(1);
				pagesupport.setTotalCount(11);
				model.addAttribute("pageSupport", pagesupport);
			}catch(Exception e){
				return "/jsp/403.jsp";
			}
		
			
		
		

		
		return "/dev/appinfo";
	}
}
