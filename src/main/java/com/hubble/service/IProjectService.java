package com.hubble.service;

import com.hubble.entiy.Project;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

public interface IProjectService {

	Project save(Project project);
	
	PageHelper<Project> getProjectsByEnquiry(Enquiry enquiry);

}
