package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.UserProject;

public interface IUserProjectDao extends JpaRepository<UserProject, String>, JpaSpecificationExecutor<UserProject> {

}
