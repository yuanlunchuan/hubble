package com.hubble.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hubble.dao.IUnRegisterAPIDao;
import com.hubble.entiy.UnRegisterAPI;
import com.hubble.service.IUnRegisterAPIService;

@Service("unRegisterAPIService")
public class UnRegisterAPIServiceImpl implements IUnRegisterAPIService {
	@Autowired
	private IUnRegisterAPIDao unRegisterAPIDao;

	public UnRegisterAPI save(UnRegisterAPI unRegisterAPI) {
		return unRegisterAPIDao.save(unRegisterAPI);
	}

	public UnRegisterAPI findByApi(String api) {
		return unRegisterAPIDao.findByApi(api);
	}

	public List<UnRegisterAPI> getAll() {
		return unRegisterAPIDao.findAll();
	}

}
