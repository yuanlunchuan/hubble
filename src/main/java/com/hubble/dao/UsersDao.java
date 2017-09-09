package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.hubble.entiy.User;

public interface UsersDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	User getUserByEmail(String email);
}
