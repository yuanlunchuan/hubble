package com.hubble.dao;

import java.util.List;

import com.hubble.entiy.Praise;

public interface IPraiseDao extends BaseDao<Praise> {

	List<Praise> findByGuestId(String guestId);

}
