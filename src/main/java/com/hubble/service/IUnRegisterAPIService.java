package com.hubble.service;

import com.hubble.entiy.UnRegisterAPI;

public interface IUnRegisterAPIService {
	UnRegisterAPI save(UnRegisterAPI unRegisterAPI);

	UnRegisterAPI findByApi(String api);
}
