package com.hubble.controller.registUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registUser/teams")
public class TeamController {
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(){
		return "registUser/teams/index";
	}
}
