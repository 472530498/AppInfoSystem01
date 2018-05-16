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
			Model model) {
		PageSupport pagesupport = appInfoService.getAllApp(currentPageNo, pageSize);
		pagesupport.setPageSize(pageSize);
		pagesupport.setCurrentPageNo(currentPageNo);
		pagesupport.setTotalCount(11);

		model.addAttribute("pageSupport", pagesupport);
		return "/dev/index";
	}
	@RequestMapping(value = "/selectappInfo", method = RequestMethod.POST)
	public String aselectappInfo(
			@RequestParam(value = "currentPageNo", required = false) Integer currentPageNo,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			Model model) {
		PageSupport pagesupport = appInfoService.getAllApp(currentPageNo, pageSize);
		pagesupport.setPageSize(pageSize);
		pagesupport.setCurrentPageNo(currentPageNo);
		pagesupport.setTotalCount(11);

		model.addAttribute("pageSupport", pagesupport);
		return "/dev/index";
	}

}
