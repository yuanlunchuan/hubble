package com.hubble.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hubble.entiy.UnRegisterAPI;
import com.hubble.service.IUnRegisterAPIService;

@Controller
@RequestMapping("/clientDebuging")
public class ClientDebugController {
	@Autowired
	private IUnRegisterAPIService unRegisterAPIService;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Integer pageSize, Integer pageNumber, ModelMap model){
		model.addAttribute("unRegisterAPIs", unRegisterAPIService.getAll());
		return "clientDebuging/index";
	}
	
	@RequestMapping(value="/detail/{id}", method=RequestMethod.GET)
	public String show(ModelMap model, @PathVariable("id") String id){
		model.addAttribute("unRegisterAPI", unRegisterAPIService.findById(id));
		return "clientDebuging/show";
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public String newPage(){
		return "clientDebuging/new";
	}
	
	@RequestMapping(value="/{api}", method=RequestMethod.GET)
	@ResponseBody
	public String invoke(@PathVariable("api") String api){
		UnRegisterAPI unRegisterAPI = unRegisterAPIService.findByApi(api);
		unRegisterAPI.setInvokeCount(unRegisterAPI.getInvokeCount()+1);
		unRegisterAPIService.save(unRegisterAPI);
		return unRegisterAPI.getResponse();
	}

	@RequestMapping(value="/{api}", method=RequestMethod.POST)
	@ResponseBody
	public String newPage(@PathVariable("api") String api){
		UnRegisterAPI unRegisterAPI = unRegisterAPIService.findByApi(api);
		unRegisterAPI.setInvokeCount(unRegisterAPI.getInvokeCount()+1);
		unRegisterAPIService.save(unRegisterAPI);
		return unRegisterAPI.getResponse();
	}

	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(UnRegisterAPI unRegisterAPI){
		unRegisterAPI.setAlive(true);
		unRegisterAPI.setCreatedAt(new Date());
		unRegisterAPI.setInvokeCount(0);
		unRegisterAPIService.save(unRegisterAPI);
		return "redirect:/clientDebuging/index";
	}
}
