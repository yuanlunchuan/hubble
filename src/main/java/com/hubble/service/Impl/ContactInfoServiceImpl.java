package com.hubble.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubble.dao.ContactInfoDao;
import com.hubble.entiy.ContactInfo;
import com.hubble.service.IContactInfoService;

@Service("contactInfoService")
public class ContactInfoServiceImpl implements IContactInfoService{
	
	@Autowired
	private ContactInfoDao contactInfoDao;

	public ContactInfo save(ContactInfo contactInfo) {
		System.out.println("ContactInfoServiceImpl execute method save");
		return contactInfoDao.save(contactInfo);
	}

}
