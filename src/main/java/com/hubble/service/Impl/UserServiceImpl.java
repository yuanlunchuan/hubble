package com.hubble.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubble.dao.UserDao;
import com.hubble.entiy.User;
import com.hubble.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;
	
	public User findById(String id){
		return userDao.findOne(id);
	}

	public User save(User user) {
		return userDao.save(user);
	}

	public void deleteByUserId(String userId) {
		 userDao.delete(userId);;
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
}