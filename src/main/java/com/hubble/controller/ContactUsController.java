package com.hubble.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hubble.entiy.ContactInfo;
import com.hubble.service.Impl.ContactInfoServiceImpl;

@Controller
@RequestMapping("/contactUs")
public class ContactUsController {

//	static ApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
//	static MailSender sender = (MailSender) actx.getBean("mailSender");
//	static SimpleMailMessage mailMessage = (SimpleMailMessage) actx.getBean("mailMessage");

	@Autowired
	private ContactInfoServiceImpl contactInfoService;

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newPage() {
		System.out.println("enter ContactUsController class and newPage method");
		return "contactUs/new";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String create(ContactInfo contactInfo, Model model) {
		System.out.println("ContactUsController class execute create method");
		contactInfoService.save(contactInfo);
		//SingleMailSend(contactInfo);
		return "redirect:/contactUs/new";
	}

	public void SingleMailSend(ContactInfo contactInfo) throws MessagingException{
//			mailMessage.setSubject(contactInfo.getSubject());
//			mailMessage.setText(contactInfo.getContent());
//			mailMessage.setTo(contactInfo.getEmail());
//			sender.send(mailMessage);
	}
}
