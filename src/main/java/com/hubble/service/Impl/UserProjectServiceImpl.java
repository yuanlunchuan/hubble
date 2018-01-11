package com.hubble.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubble.dao.IUserProjectDao;
import com.hubble.entiy.UserProject;
import com.hubble.service.IUserProjectService;

@Service
public class UserProjectServiceImpl implements IUserProjectService {

	@Autowired
	private IUserProjectDao userProjectDao;

	@Override
	public UserProject save(UserProject userProject) {
		return userProjectDao.save(userProject);
	}

	@Override
	public Optional<UserProject> findByUserIdAndProjectId(String userId, String projectId) {
		return Optional.ofNullable(userProjectDao.findByUserIdAndProjectId(userId,projectId));
	}

}
