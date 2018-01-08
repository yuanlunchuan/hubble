package com.hubble.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hubble.dao.IMessageDao;
import com.hubble.entiy.Message;
import com.hubble.service.AbstractService;
import com.hubble.service.IMessageService;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

@Service("messageService")
public class MessageServiceImpl extends AbstractService<Message> implements IMessageService {
	@Autowired
	private IMessageDao messageDao;

	@Override
	public PageHelper<Message> findByEnquiry(Enquiry enquiry) {
		PageHelper<Message> result = new PageHelper<>();
		Pageable p = new PageRequest(enquiry.getPageNumber()-1, enquiry.getPageSize());

		Specification<Message> specification = (Root<Message> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
				List<Predicate> predicates = new ArrayList<Predicate>();
				Predicate[] predicate = new Predicate[predicates.size()];
				return cb.and(predicates.toArray(predicate));
		};

		Page<Message> page = messageDao.findAll(specification, p);
		result.setContent(page.getContent());
		result.setTotal(page.getTotalElements());
		result.setTotalPage(page.getTotalPages());
		result.setCurrentPage(enquiry.getPageNumber());
		result.setPageSize(enquiry.getPageSize());

		return result;
	}

}
