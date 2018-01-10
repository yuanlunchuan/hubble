package com.hubble.service.Impl;

import org.springframework.stereotype.Service;

import com.hubble.entiy.Guest;
import com.hubble.service.AbstractService;
import com.hubble.service.IGuestService;

@Service("guestService")
public class GuestServiceImpl extends AbstractService<Guest> implements IGuestService {

}
