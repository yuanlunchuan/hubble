package com.hubble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.ContactInfo;
import com.hubble.service.IContactInfoService;
import com.hubble.util.SendMailHelper;

@Controller
@RequestMapping("/contactUs")
public class ContactUsController {

	@Autowired
	private IContactInfoService contactInfoService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPage() {
		System.out.println("enter ContactUsController class and newPage method");
		return "contactUs/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(ContactInfo contactInfo, Model model) {
		System.out.println("ContactUsController class execute create method");
		contactInfoService.save(contactInfo);

		String subject = contactInfo.getSubject(); // 标题
		String sendTo = contactInfo.getEmail();// 接收者邮件
		String msg = contactInfo.getContent(); // 发送内容
		String ret = SendMailHelper.Sender(subject, msg, sendTo);
		System.out.println("邮件发送结果：" + ret);

		return "redirect:/contactUs/new";
	}

}
