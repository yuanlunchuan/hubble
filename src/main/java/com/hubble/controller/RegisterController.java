package com.hubble.controller;

import java.util.ResourceBundle;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hubble.entiy.User;
import com.hubble.service.IUserService;
import com.hubble.util.CryptographyUtil;
import com.hubble.util.SendMailHelper;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private IUserService userService;
	ResourceBundle parmResource = ResourceBundle.getBundle("config");

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String newPage(@RequestParam(value="action", required=false)String action,
			@RequestParam(value="email", required=false)String email,
			@RequestParam(value="validateCode", required=false)String validateCode) {

		if ("activate".equals(action)&&userService.processActivate(email, validateCode)) {// 调用激活方法
			return "redirect:/registUser/dashborad";
		}else{
			return "register/new";	
		}
	}

	@RequestMapping(value = "/create", method = {RequestMethod.POST })
	public String registerUsers(@Valid User user, BindingResult result, RedirectAttributes model) {
		StringBuilder errorMessage = new StringBuilder();
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()+" "));
			model.addFlashAttribute("errorMessage", errorMessage.toString());
			return "redirect:/register/new";
		}

		User queryUser = userService.findByEmail(user.getEmail());
		if (null != queryUser) {
			errorMessage.append("该账号已注册，请直接登录");
			model.addFlashAttribute("errorMessage", errorMessage.toString());
			return "redirect:/register/new";
		}

		Integer x = (int) ((Math.random() * 9 + 1) * 10000); // 随机生成5位验证码
		String validateCode = x.toString();
		user.setPassword(user.getPassword());
		user.setValidateCode(validateCode);
		userService.save(user);

		StringBuffer msg = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！\n");

		String host = parmResource.getString("host");
		msg.append(host + "/register/new?action=activate&email=");

		msg.append(user.getEmail());
		msg.append("&validateCode=");
		msg.append(user.getValidateCode());

		SendMailHelper.sendHtmlEmail("注册激活", msg, user.getEmail());

		return "redirect:/registUser/dashborad";
	}
}
