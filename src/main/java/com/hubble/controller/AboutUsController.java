package com.hubble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.Praise;
import com.hubble.service.IPraiseService;

@Controller
@RequestMapping("/aboutUs")
public class AboutUsController {
	@Autowired
	private IPraiseService praiseService;

	@RequestMapping(value="show", method=RequestMethod.GET)
	public String show(Model model){
		return "aboutUs/show";
	}

	@RequestMapping(value="praise", method=RequestMethod.POST)
	public String create(@CookieValue(value="guestId", required=false)String guestId){
		Praise praise = new Praise();
		praise.setGuestId(guestId);
		praiseService.save(praise);

		return "rdirect:/aboutUs/show";
	}
}
