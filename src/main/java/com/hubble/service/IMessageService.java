package com.hubble.service;

import com.hubble.entiy.Message;
import com.hubble.util.Enquiry;
import com.hubble.util.PageHelper;

public interface IMessageService extends IBaseService<Message> {

	PageHelper<Message> findByEnquiry(Enquiry enquiry);

}
