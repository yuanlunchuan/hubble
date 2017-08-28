package com.hubble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newPage(){
	  return "register/new";
	}
}
