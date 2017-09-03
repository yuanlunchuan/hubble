package com.hubble.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.ContactInfo;
import com.hubble.entiy.User;

public interface ContactInfoDao extends JpaRepository<ContactInfo, String>, JpaSpecificationExecutor<ContactInfo> {
	
}

