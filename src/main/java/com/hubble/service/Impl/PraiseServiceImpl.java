package com.hubble.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubble.dao.IPraiseDao;
import com.hubble.entiy.Praise;
import com.hubble.service.AbstractService;
import com.hubble.service.IPraiseService;

@Service("praiseService")
public class PraiseServiceImpl extends AbstractService<Praise> implements IPraiseService {

	@Autowired
	private IPraiseDao praiseDao;

	@Override
	public List<Praise> findByGuestId(String guestId) {
		return praiseDao.findByGuestId(guestId);
	}

}
