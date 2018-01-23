package com.hubble.service;

import java.util.List;

import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.hubble.dao.BaseDao;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

public class AbstractService<T> implements IBaseService<T> {
	@Autowired
	private BaseDao<T> baseDao;

	@Override
	public void delete(String id) {
		baseDao.delete(id);
	}

	@Override
	public void delete(T t) {
		baseDao.delete(t);
	}

	@Override
	public void delete(List<String> ids) {
		if(CollectionUtils.isEmpty(ids))return;

		for(String id:ids){
			baseDao.delete(id);			
		}
	}

	@Override
	public void update(T t) {
		save(t);
	}

	@Override
	public void update(List<T> list) {
		save(list);
	}

	@Override
	public T get(String id) {
		return baseDao.findOne(id);
	}

	@Override
	public List<T> get(List<String> ids) {
		return baseDao.findAll(ids);
	}

	@Override
	public List<T> getAll() {
		return baseDao.findAll();
	}

	@Override
	public T save(T t) {
		return baseDao.save(t);
	}

	@Override
	public List<T> save(List<T> list) {
		return baseDao.save(list);
	}

	@Override
	public PageHelper<T> findByEnquiry(Enquiry enquiry) {
		return null;
	}

}
