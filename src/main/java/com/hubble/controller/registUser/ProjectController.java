package com.hubble.controller.registUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hubble.entiy.Project;
import com.hubble.entiy.User;
import com.hubble.entiy.UserProject;
import com.hubble.service.IProjectService;
import com.hubble.service.IUserProjectService;
import com.hubble.service.IUserService;
import com.hubble.util.Enquiry;

@Controller
@RequestMapping("/registUser/projects")
public class ProjectController {
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserProjectService userProjectService;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(Project project){
		projectService.save(project);
      return "redirect:/registUser/projects";		
	}

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(@RequestParam(value="pageNumber", required=false, defaultValue ="1") Integer pageNumber,
			@RequestParam(value="pageSize", required=false, defaultValue="18") Integer pageSize,
			ModelMap model){
		Enquiry enquiry = new Enquiry();
		enquiry.setPageNumber(pageNumber);
		enquiry.setPageSize(pageSize);
		model.addAttribute("collection", projectService.getProjectsByEnquiry(enquiry));

		return "registUser/projects/index";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id")String id, ModelMap modelMap){
		modelMap.addAttribute("projectId", id);
		return "registUser/projects/show";
	}

	@RequestMapping(value="{id}", method=RequestMethod.POST)
	public String addUser(@PathVariable("id")String id, String email){
		User user = userService.findByEmail(email);
		if(null!=user){
			UserProject userProject = new UserProject();
			userProject.setProjectId(id);
			userProject.setUserId(user.getId());
			userProjectService.save(userProject);
		}
		return "redirect:/registUser/projects/"+id;
	}
}
