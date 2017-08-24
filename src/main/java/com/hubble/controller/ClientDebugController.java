package com.hubble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/clientDebuging")
public class ClientDebugController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String newPage(){
		return "clientDebuging/new";
	}
}
