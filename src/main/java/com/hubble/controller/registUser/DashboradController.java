package com.hubble.controller.registUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registUser/dashborad")
public class DashboradController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String show(){
		return "registUser/dashborad/show";
	}
}