package com.hubble.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.hubble.entiy.Project;

public interface IProjectDao extends JpaRepository<Project, String>,JpaSpecificationExecutor<Project> {

}
