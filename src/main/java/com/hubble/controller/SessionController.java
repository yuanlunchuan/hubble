package com.hubble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.Users;
import com.hubble.service.IUsersService;

@Controller
@RequestMapping("/sessions")
public class SessionController {

	@Autowired
	private IUsersService usersService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPage() {
		System.out.println("Enter login page");
		return "sessions/new";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Users users, Model model) {
		System.out.println("start login: users= " + users);
		Users queryUser = usersService.findByEmail(users.getEmail());
		
		if (null == queryUser) {
			System.out.println("找不到该账号，请先注册账号");
			return "redirect:/sessions/new";
		}

		System.out.println("validate: input pwd= " + users.getPassword()+" & queryUser pwd= "+queryUser.getPassword());
		if (!users.getPassword().equals(queryUser.getPassword())) {
			System.out.println("密码不正确请重新输入");
			return "redirect:/sessions/new";
		}
		
		System.out.println("login success");
		return "redirect:/registUser/dashborad";
	}

}
