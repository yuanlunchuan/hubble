package com.hubble.controller;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String newPage(HttpServletRequest request) {
		System.out.println("Enter register page");
		String action = request.getParameter("action");
		System.out.println("registerUsers action = " + action);
		
		if("activate".equals(action)){
			//激活
            String email = request.getParameter("email");//获取email
            String validateCode = request.getParameter("validateCode");//激活码
            try {
            	if(userService.processActivate(email , validateCode)){//调用激活方法
            		System.out.println("registerUsers activate_success");
            		return "redirect:/sessions/new";
            	}else{
            		System.out.println("registerUsers activate_failure");
            	}
            } catch (ServiceException e) {
                request.setAttribute("message" , e.getMessage());
                System.out.println("registerUsers activate_failure");
            }
		}
		
		return "register/new";
	}
	
	@RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
	public String registerUsers(User user, Model model) {
		User queryUser = userService.findByEmail(user.getEmail());
		if (null != queryUser) {
			System.out.println("该账号已注册，请直接登录");
			return "redirect:/sessions/new";
		}
		Integer x =(int)((Math.random()*9+1)*10000); //随机生成5位验证码 
        String validateCode = x.toString(); 
        user.setPassword(CryptographyUtil.md5(user.getPassword(), "hubble"));
		user.setValidateCode(validateCode);
		userService.save(user);

		StringBuffer msg = new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！\n");
		
		String host = parmResource.getString("host");
		msg.append(host+"/register/new?action=activate&email=");
		
		msg.append(user.getEmail());
		msg.append("&validateCode=");
		msg.append(user.getValidateCode());

		String ret = SendMailHelper.sendHtmlEmail("注册激活", msg, user.getEmail());

		return "redirect:/sessions/new";
	}
}
