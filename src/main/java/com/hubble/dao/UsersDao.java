package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.hubble.entiy.Users;

public interface UsersDao extends JpaRepository<Users, String>, JpaSpecificationExecutor<Users> {
	Users getUsersByEmail(String email);
}
