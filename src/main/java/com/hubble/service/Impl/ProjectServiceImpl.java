package com.hubble.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubble.dao.IProjectDao;
import com.hubble.entiy.Project;
import com.hubble.service.IProjectService;

@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private IProjectDao projectDao;

	@Override
	public Project save(Project project) {
		return projectDao.save(project);
	}
	
}
