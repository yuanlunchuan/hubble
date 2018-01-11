package com.hubble.controller.registUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hubble.entiy.RegisterAPI;
import com.hubble.service.IRegisterAPIService;
import com.hubble.util.RedirectAttributeHelper;

@Controller
@RequestMapping("/registUser/projects/{projectId}/interfaces")
public class InterfaceController {
	@Autowired
	private IRegisterAPIService registerAPIService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(){
		return "registUser/interfaces/index";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newPage(@PathVariable("projectId") String projectId, ModelMap model){
		model.addAttribute("projectId", projectId);
		return "registUser/interfaces/new";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(RegisterAPI registerAPI, RedirectAttributes model){
		if(null!=registerAPIService.save(registerAPI)){
			RedirectAttributeHelper.successMessage(model, "保存成功");
		}else{
			RedirectAttributeHelper.successMessage(model, "保存失败");
		}
		return "redirect:/registUser/projects/"+registerAPI.getProjectId();
	}

	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String edit(){
		return "registUser/interfaces/edit";
	}
}
