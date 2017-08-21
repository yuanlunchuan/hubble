package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.User;

public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {  
}
