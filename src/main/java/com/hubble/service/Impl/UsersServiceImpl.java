package com.hubble.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hubble.dao.UsersDao;
import com.hubble.entiy.User;
import com.hubble.service.IUsersService;

@Service("usersService")
public class UsersServiceImpl implements IUsersService {

	@Autowired
	private UsersDao userDao;

	public User save(User user) {
		return userDao.save(user);
	}

	public void deleteByUsersId(String userId) {
		userDao.delete(userId);
	}

	public User update(User user) {
		return userDao.save(user);
	}

	public User findByUserId(String userId) {
		return userDao.findOne(userId);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	public User findByUsersId(String userId) {
		return null;
	}

}
