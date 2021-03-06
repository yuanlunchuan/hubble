package com.hubble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.User;

public interface IUserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	List<User> getUsersBySql(String userName);

	User findByEmail(String email);
}
