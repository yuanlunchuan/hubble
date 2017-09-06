package com.hubble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.dao.UsersDao;
import com.hubble.entiy.Users;
import com.hubble.service.IUsersService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private IUsersService usersService;
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String newPage(){
		System.out.println("Enter register page");
	  return "register/new";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String registerUsers(Users users, Model model){
		System.out.println("registerUsers users = "+users);
		Users queryUser = usersService.findByEmail(users.getEmail());
		if (null != queryUser) {
			System.out.println("该账号已注册，请直接登录");
			return "redirect:/sessions/new";
		}
		usersService.save(users);
		System.out.println("注册成功");
		return "redirect:/sessions/new";
	}
}
