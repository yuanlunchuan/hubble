package com.hubble.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMailHelper {

	private final static String FROM_MAIL = "13551031965@163.com";
	private final static String FROM_USER_NAME = "13551031965@163.com";
	private final static String MAIL_PASSWORD = "5yuanlunchuan";
	private final static String FROM_USER_NICK_NAME = "yuanlunchuan";// 发送者名字
	private final static String PROTOCOL = "smtp";// 协议
	private final static String HOST = "smtp.163.com";// 发送主机

	public static String Sender(String subject, String msg, String sendTo) {
		try {
			if(true){
				return "";
			}
			// 需要认证
			Properties props = new Properties();
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", PROTOCOL);
			props.put("mail.from", FROM_MAIL);
			// 创建发送器
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(HOST);
			sender.setUsername(FROM_USER_NAME);
			sender.setPassword(MAIL_PASSWORD);
			// 创建消息
			MimeMessage message = sender.createMimeMessage();
			message.addHeader("X-Mailer", "Java Mailer");
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(sendTo);
			helper.setFrom(FROM_MAIL, FROM_USER_NICK_NAME);
			helper.setSubject(subject);
			helper.setText(msg);
			helper.setSentDate(new Date());
			// 开始发送
			sender.setJavaMailProperties(props);
			sender.send(message);
		} catch (Exception e) {
			System.out.println("Error:" + e);
			return "Failure";
		}
		return "Success";
	}
	
	public static String sendHtmlEmail(String subject, StringBuffer msg, String sendTo) {
		try {
			// 需要认证
			Properties props = new Properties();
			props.put("mail.smtp.host", HOST);
			props.put("mail.smtp.auth", "true");
			props.put("mail.transport.protocol", PROTOCOL);
			props.put("mail.from", FROM_MAIL);
			// 创建发送器
			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(HOST);
			sender.setUsername(FROM_USER_NAME);
			sender.setPassword(MAIL_PASSWORD);
			// 创建消息
			MimeMessage message = sender.createMimeMessage();
			message.addHeader("X-Mailer", "Java Mailer");
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(sendTo);
			helper.setFrom(FROM_MAIL, FROM_USER_NICK_NAME);
			helper.setSubject(subject);
			helper.setText(msg.toString());
			helper.setSentDate(new Date());
			// 开始发送
			sender.setJavaMailProperties(props);
			sender.send(message);
		} catch (Exception e) {
			System.out.println("Error:" + e);
			return "Failure";
		}
		return "Success";
	}

}
