package cn.app.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/selectappInfo/{name}", method = RequestMethod.GET)
	public String selectappInfo(
			@RequestParam(value = "currentPageNo", required = false, defaultValue = "1") Integer currentPageNo,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize, 
			@RequestParam(value = "softwareName", required = false, defaultValue = "")String softwareName,
			@RequestParam(value = "interfaceLanguage", required = false, defaultValue = "")String interfaceLanguage,
			@PathVariable(value = "name")String name,
			Model model) {
		PageSupport pagesupport = appInfoService.getAllApp(softwareName,interfaceLanguage,currentPageNo, pageSize);
		pagesupport.setPageSize(pageSize);
		pagesupport.setCurrentPageNo(currentPageNo);
		pagesupport.setTotalCount(appInfoService.getAppNum(softwareName,interfaceLanguage));
    
		model.addAttribute("pageSupport", pagesupport);
		if(name!=""&&name!=null){
			return  "/back/appinfo";
			
		}
		else  return "/dev/appinfo";
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
	
	
	@RequestMapping(value = "/deleteappInfo/{id}", method = RequestMethod.GET)
	public String deleteappInfo(@PathVariable("id")Integer id,	
			Model model) {

				appInfoService.deleteAppById(id);		
		        return "redirect:/selectappInfo";
	}
	
	@RequestMapping(value = "/setappstatus",method = RequestMethod.POST)
	public String setappstatus(
			@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "status", required = false) Integer status,
			Model model) {
			try{
				
				appInfoService.setAppStatus(id,status);
				
			}catch(Exception e){
				System.out.println(e.getMessage());
				return "/jsp/403.jsp";
			}	
			return "redirect:/selectappInfo/admin";
	}
}
