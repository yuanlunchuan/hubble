package com.hubble.service.Impl;

import org.springframework.stereotype.Service;

import com.hubble.entiy.Message;
import com.hubble.service.AbstractService;
import com.hubble.service.IMessageService;

@Service("messageService")
public class MessageServiceImpl extends AbstractService<Message> implements IMessageService {

}
