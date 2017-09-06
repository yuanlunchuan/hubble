package com.hubble.controller.registUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registUser/projects")
public class ProjectController {
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(){
		return "registUser/projects/index";
	}
}
