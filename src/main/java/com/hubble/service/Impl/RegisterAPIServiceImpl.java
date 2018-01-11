package com.hubble.service.Impl;

import org.springframework.stereotype.Service;

import com.hubble.entiy.RegisterAPI;
import com.hubble.service.AbstractService;
import com.hubble.service.IRegisterAPIService;

@Service("RegisterAPIService")
public class RegisterAPIServiceImpl extends AbstractService<RegisterAPI> implements IRegisterAPIService {

}
