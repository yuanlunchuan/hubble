package com.hubble.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hubble.entiy.Guest;
import com.hubble.service.IGuestService;
import com.hubble.util.CookieHelper;

import freemarker.log.Logger;

@Controller
public class SitesController {
	private Logger logger = Logger.getLogger("SitesController");
	
	@Autowired
	private IGuestService guestService;

	@RequestMapping(value={"", "/", "home"})
	public String home(@CookieValue(value="guestId", required=false)String guestId, HttpServletResponse response){
		if(StringUtils.isBlank(guestId)){
			Guest guest = new Guest();
			guest = guestService.save(guest);
			CookieHelper cookieHelper = new CookieHelper();
			cookieHelper.addCookie(response, "guestId", guest.getId());
		}
		return "sites/sites";
	}
}
