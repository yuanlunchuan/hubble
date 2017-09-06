package com.hubble.service;

import java.util.List;

import com.hubble.entiy.User;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

public interface IUserService {
	User save(User user);
	
	void deleteByUserId(String userId);
	
	User update(User user);
	
	User findByUserId(String userId);
	
	List<User> findAll();
	
	PageHelper<User> findByEnquiry(Enquiry enquiry);
	
	List<User> getUsersBySql(String userName);
	
	List<User> findByEmail(String email);
}
