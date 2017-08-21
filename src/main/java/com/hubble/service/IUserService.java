package com.hubble.service;

import java.util.List;

import com.hubble.entiy.User;

public interface IUserService {
	User save(User user);
	
	void deleteByUserId(String userId);
	
	User update(User user);
	
	User findByUserId(String userId);
	
	List<User> findAll();
}
