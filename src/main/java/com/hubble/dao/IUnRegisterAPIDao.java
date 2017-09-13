package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.UnRegisterAPI;

public interface IUnRegisterAPIDao extends JpaRepository<UnRegisterAPI, String>, JpaSpecificationExecutor<UnRegisterAPI> {
	UnRegisterAPI findByApi(String api);
}
