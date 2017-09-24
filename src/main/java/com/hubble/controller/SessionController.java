package com.hubble.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hubble.entiy.User;
import com.hubble.service.IUserService;
import com.hubble.util.CryptographyUtil;

@Controller
@RequestMapping("/sessions")
public class SessionController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newPage(){
		return "sessions/new";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login(User user, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		User dbUser = userService.findByEmail(user.getEmail());
		if(null!=dbUser&&CryptographyUtil.md5(user.getPassword(), "hubble").equals(dbUser.getPassword())){
			return "redirect:/registUser/dashborad";
		}else{
			return "redirect:/sessions/new";
		}
		
		/*
		Subject subject = SecurityUtils.getSubject();
		user.setPassword(CryptographyUtil.md5(user.getPassword(), "hubble"));
		UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPassword());
		try {
			subject.login(token);
			Session session = subject.getSession();
			user = userService.findByEmail(user.getEmail());
			session.setAttribute("userId", user.getId());
			return "sessions/new";
		} catch (Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("errorMessage", "账号密码错误");
			return "redirect:/sessions/new";
		}
		*/
	}
}
