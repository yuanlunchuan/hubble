package com.hubble.service;

import java.util.List;

import com.hubble.entiy.UnRegisterAPI;

public interface IUnRegisterAPIService {
	UnRegisterAPI save(UnRegisterAPI unRegisterAPI);

	UnRegisterAPI findByApi(String api);
	
	UnRegisterAPI findById(String id);

	List<UnRegisterAPI> getAll();
}
