package com.hubble.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hubble.entiy.User;

public class IUserDaoImpl {
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<User> getUsersBySql(String userName) {
		StringBuilder sb = new StringBuilder("select * from i_users WHERE username LIKE \"%" + userName + "%\"");
		Query query = em.createNativeQuery(sb.toString(), User.class);
		return query.getResultList();
	}

	public User getUsersByEmail(String email) {
		StringBuilder sb = new StringBuilder("select * from i_users WHERE email = " + email);
		Query query = em.createNativeQuery(sb.toString(), User.class);
		return (null == query.getSingleResult() ? null : (User) query.getSingleResult());// query.getResultList();
	}
}
