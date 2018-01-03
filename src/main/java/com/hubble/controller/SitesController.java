package com.hubble.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import freemarker.log.Logger;

@Controller
public class SitesController {
	private Logger logger = Logger.getLogger("SitesController");

	@RequestMapping(value={"", "/", "home"})
	public String home(){
		logger.info("-----------------shouye-------");
		return "sites/sites";
	}
}
