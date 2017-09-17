package com.hubble.controller.registUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/registUser/interfaces")
public class InterfaceController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(){
		return "registUser/interfaces/index";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newPage(){
		return "registUser/interfaces/new";
	}
}
