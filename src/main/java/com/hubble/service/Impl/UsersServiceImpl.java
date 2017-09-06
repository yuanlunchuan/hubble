package com.hubble.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hubble.dao.UsersDao;
import com.hubble.entiy.Users;
import com.hubble.service.IUsersService;

@Service("usersService")
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersDao usersDao;

	public Users save(Users users) {
		return usersDao.save(users);
	}

	public void deleteByUsersId(String usersId) {
		usersDao.delete(usersId);
	}

	public Users update(Users users) {
		return usersDao.save(users);
	}

	public Users findByUsersId(String userId) {
		return usersDao.findOne(userId);
	}

	public List<Users> findAll() {
		return usersDao.findAll();
	}

	public Users findByEmail(String email) {
		return usersDao.getUsersByEmail(email);
	}

}
