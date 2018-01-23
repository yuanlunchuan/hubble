package com.hubble.service;

import java.util.List;

import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

public interface IBaseService<T> {
	T save(T t);

	List<T> save(List<T> list);

	void delete(String id);

	void delete(T t);

	void delete(List<String> ids);

	void update(T t);

	void update(List<T> list);

	T get(String id);

	List<T> get(List<String> ids);

	List<T> getAll();
	
	PageHelper<T> findByEnquiry(Enquiry enquiry);
}
