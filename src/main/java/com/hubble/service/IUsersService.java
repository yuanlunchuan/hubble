package com.hubble.service;

import java.util.List;
import com.hubble.entiy.Users;

public interface IUsersService {
	Users save(Users users);

	void deleteByUsersId(String userId);

	Users update(Users users);

	Users findByUsersId(String userId);
	
	List<Users> findAll();
	
	Users findByEmail(String email);
}
