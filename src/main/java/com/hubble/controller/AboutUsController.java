package com.hubble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {
	@RequestMapping(value="show", method=RequestMethod.GET)
	public String show(){
		return "aboutUs/show";
	}
}
