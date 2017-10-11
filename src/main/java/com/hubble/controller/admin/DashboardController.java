package com.hubble.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String adminHome(){
		return "admin/dashboard/show";
	}
}
