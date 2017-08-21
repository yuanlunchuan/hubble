package com.hubble;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class DemoController {

	@RequestMapping(value="", method=RequestMethod.GET)
	public String hello(String name, ModelMap model){
		System.out.println("-------name: "+name);
		model.addAttribute("name", name);
		return "hello";
	}
}
