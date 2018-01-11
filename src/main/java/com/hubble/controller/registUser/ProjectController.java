package com.hubble.controller.registUser;

import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hubble.entiy.Project;
import com.hubble.entiy.User;
import com.hubble.entiy.UserProject;
import com.hubble.service.IProjectService;
import com.hubble.service.IUserProjectService;
import com.hubble.service.IUserService;
import com.hubble.util.Enquiry;
import com.hubble.util.RedirectAttributeHelper;

@Controller
@RequestMapping("/registUser/projects")
public class ProjectController {
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IUserProjectService userProjectService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(Project project) {
		projectService.save(project);
		return "redirect:/registUser/projects";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "18") Integer pageSize, ModelMap model) {
		Enquiry enquiry = new Enquiry();
		enquiry.setPageNumber(pageNumber);
		enquiry.setPageSize(pageSize);
		model.addAttribute("collection", projectService.getProjectsByEnquiry(enquiry));

		return "registUser/projects/index";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id, ModelMap modelMap) {
		modelMap.addAttribute("projectId", id);
		return "registUser/projects/show";
	}

	@RequestMapping(value = "{projectId}", method = RequestMethod.POST)
	public String addUser(@PathVariable("projectId") String projectId, String email, RedirectAttributes model) {
		Optional<User> userOpt = userService.findByEmail(email);
		if (!userOpt.isPresent()) {
			RedirectAttributeHelper.errorMessage(model, "用户不存在");
			return "redirect:/registUser/projects/" + projectId;
		}
		Optional<UserProject> userProjectOpt = userProjectService.findByUserIdAndProjectId(userOpt.get().getId(),
				projectId);
		if (userProjectOpt.isPresent()) {
			RedirectAttributeHelper.errorMessage(model, "用户已经添加");
			return "redirect:/registUser/projects/" + projectId;
		}
		UserProject userProject = new UserProject();
		userProject.setProjectId(projectId);
		userProject.setUserId(userOpt.get().getId());
		userProjectService.save(userProject);

		RedirectAttributeHelper.successMessage(model, "添加成功");
		return "redirect:/registUser/projects/" + projectId;
	}
}
