package com.hubble.service.Impl;

import java.util.ArrayList;
import java.util.List;

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

import com.hubble.dao.UserDao;
import com.hubble.entiy.User;
import com.hubble.service.IUserService;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserDao userDao;

	public User findById(String id) {
		return userDao.findOne(id);
	}

	public User save(User user) {
		return userDao.save(user);
	}

	public void deleteByUserId(String userId) {
		userDao.delete(userId);
	}

	public User update(User user) {
		return userDao.save(user);
	}

	public User findByUserId(String userId) {
		return userDao.findOne(userId);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public PageHelper<User> findByEnquiry(final Enquiry enquiry) {
		PageHelper<User> result = new PageHelper<User>();

		Pageable p = new PageRequest(enquiry.getPageNumber()-1, enquiry.getPageSize());

		Specification<User> specification = new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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

		Page<User> page = userDao.findAll(specification, p);
		result.setContent(page.getContent());
		result.setTotal(page.getTotalElements());
		result.setTotalPage(page.getTotalPages());

		return result;
	}

	public List<User> getUsersBySql(String userName) {
		return userDao.getUsersBySql(userName);
	}
}