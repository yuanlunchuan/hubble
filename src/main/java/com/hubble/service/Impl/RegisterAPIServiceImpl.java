package com.hubble.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import org.apache.maven.shared.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hubble.dao.IRegisterAPIDao;
import com.hubble.entiy.RegisterAPI;
import com.hubble.service.AbstractService;
import com.hubble.service.IRegisterAPIService;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

@Service("RegisterAPIService")
public class RegisterAPIServiceImpl extends AbstractService<RegisterAPI> implements IRegisterAPIService {
	@Autowired
	private IRegisterAPIDao registerAPIDao;

	@Override
	public PageHelper<RegisterAPI> findByEnquiry(Enquiry enquiry) {
		PageHelper<RegisterAPI> result = new PageHelper<>();
		
		Pageable p = new PageRequest(enquiry.getPageNumber()-1, enquiry.getPageSize());

		Page<RegisterAPI> page=registerAPIDao.findAll((root, query, cb)->{
			List<Predicate> predicates = new ArrayList<Predicate>();
			String projectId = (String) enquiry.getSearchParams().get("projectId");

			if(StringUtils.isNotBlank(projectId)){
				predicates.add(cb.equal(root.<String>get("projectId"), projectId));
			}

			Predicate[] pre = new Predicate[predicates.size()];
			return cb.and(predicates.toArray(pre));
		},p);

		result.setContent(page.getContent());
		result.setTotal(page.getTotalElements());
		result.setTotalPage(page.getTotalPages());

		return result;
	}

}
