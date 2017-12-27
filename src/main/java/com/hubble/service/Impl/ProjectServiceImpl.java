package com.hubble.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hubble.dao.IProjectDao;
import com.hubble.entiy.Project;
import com.hubble.service.IProjectService;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

@Service("projectService")
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private IProjectDao projectDao;
	
	@Override
	public Project save(Project project) {
		Random rand =new Random();
		int i=rand.nextInt(15)+1;
		project.setImgUrl("static/registUser/image/project"+i+".jpg");
		return projectDao.save(project);
	}

	@Override
	public PageHelper<Project> getProjectsByEnquiry(Enquiry enquiry) {
		PageHelper<Project> result = new PageHelper<Project>();

		Pageable p = new PageRequest(enquiry.getPageNumber() - 1, enquiry.getPageSize());

		Specification<Project> specification = new Specification<Project>() {
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<Predicate>();

				Predicate keywordPre;
				String keyword = (String) enquiry.getSearchParams().get("keyword");
				if (StringUtils.isNotBlank(keyword)) {
					Predicate p1 = cb.like(root.<String>get("username"), "%" + keyword + "%");
					Predicate p2 = cb.like(root.<String>get("nickName"), "%" + keyword + "%");
					keywordPre = cb.or(p1, p2);

					predicates.add(keywordPre);
				}

				Predicate agePre;
				Integer age = (Integer) enquiry.getSearchParams().get("age");
				if (null != age) {
					agePre = cb.equal(root.<Integer>get("age"), age);
					predicates.add(agePre);
				}

				Predicate[] p = new Predicate[predicates.size()];
				return cb.and(predicates.toArray(p));
			}
		};

		Page<Project> page = projectDao.findAll(specification, p);
		result.setContent(page.getContent());
		result.setTotal(page.getTotalElements());
		result.setTotalPage(page.getTotalPages());
		result.setCurrentPage(enquiry.getPageNumber());
		result.setPageSize(enquiry.getPageSize());

		return result;
	}
	
}
