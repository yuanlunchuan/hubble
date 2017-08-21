package com.hubble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.User;
import com.hubble.service.Impl.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class DemoController {
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(ModelMap model){
		model.addAttribute("users", userService.findAll());
		return "users/index";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newPage(ModelMap model){
		return "users/new";
	}
	
	@RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
	public String newPage(@PathVariable("id") String id, ModelMap model){
		model.addAttribute("user", userService.findById(id));
		return "users/edit";
	}

	@RequestMapping(value = "", method=RequestMethod.POST)
	public String create(User user, Model model) {
		userService.save(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/{userId}/update", method = RequestMethod.POST)
	public String update(User user, @PathVariable("userId")String userId) {
		user.setId(userId);
		userService.update(user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/{userId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("userId")String userId) {
		userService.deleteByUserId(userId);
		return "redirect:/users";
	}

}
