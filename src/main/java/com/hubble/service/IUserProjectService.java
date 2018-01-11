package com.hubble.service;

import java.util.Optional;

import com.hubble.entiy.UserProject;

public interface IUserProjectService {
	UserProject save(UserProject userProject);

	Optional<UserProject> findByUserIdAndProjectId(String userId, String projectId);
}
