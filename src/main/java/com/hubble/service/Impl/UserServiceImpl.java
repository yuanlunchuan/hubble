package com.hubble.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.maven.shared.utils.StringUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hubble.dao.IUserDao;
import com.hubble.entiy.User;
import com.hubble.service.IUserService;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private IUserDao userDao;

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

		Pageable p = new PageRequest(enquiry.getPageNumber() - 1, enquiry.getPageSize());

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

	public Optional<User> findByEmail(String email) {
		return  Optional.ofNullable(userDao.findByEmail(email));
	}

	public boolean processActivate(String email, String validateCode) {
		try {
			// 数据访问层，通过email获取用户信息
			Optional<User> userOpt = findByEmail(email);
			userOpt.ifPresent((user)->{
				// 验证用户激活状态
				if (user.getStatus() == 0) {
					// 没激活
					Date currentTime = new Date();// 获取当前时间
					// 验证链接是否过期
					currentTime.before(user.getRegisterTime());
					if (currentTime.before(user.getLastActivateTime())) {
						// 验证激活码是否正确
						if (validateCode.equals(user.getValidateCode())) {
							// 激活成功， 并更新用户的激活状态，为已激活
							user.setStatus(1);// 把状态改为激活
							userDao.save(user);
						} else {
							System.out.println("激活码不正确");
						}
					} else {
						System.out.println("激活码已过期！");
					}
				} else {
				}
			});
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println("ServiceException : " + e);
		}

		return false;
	}
}