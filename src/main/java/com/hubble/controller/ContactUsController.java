package com.hubble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contactUs")
public class ContactUsController {
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newPage(){
		return "contactUs/new";
	}
}
