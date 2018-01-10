package com.hubble.service;

import java.util.List;

import com.hubble.entiy.Praise;

public interface IPraiseService extends IBaseService<Praise> {
	List<Praise> findByGuestId(String guestId);
}
