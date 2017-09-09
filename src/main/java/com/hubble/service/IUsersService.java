package com.hubble.service;

import java.util.List;

import com.hubble.entiy.User;

public interface IUsersService {
	User save(User user);

	void deleteByUsersId(String userId);

	User update(User user);

	User findByUsersId(String userId);
	
	List<User> findAll();
	
	User findByEmail(String email);
}
