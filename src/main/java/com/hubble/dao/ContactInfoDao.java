package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.ContactInfo;

public interface ContactInfoDao extends JpaRepository<ContactInfo, String>, JpaSpecificationExecutor<ContactInfo> {
	
}
