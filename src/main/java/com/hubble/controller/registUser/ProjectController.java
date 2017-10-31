package com.hubble.controller.registUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.Project;
import com.hubble.service.IProjectService;

@Controller
@RequestMapping("/registUser/projects")
public class ProjectController {
	@Autowired
	private IProjectService projectService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(Project project){
		projectService.save(project);
      return "redirect:/registUser/projects";		
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(){
		return "registUser/projects/index";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(String id, ModelMap modelMap){
		
		return "registUser/projects/show";
	}
}
