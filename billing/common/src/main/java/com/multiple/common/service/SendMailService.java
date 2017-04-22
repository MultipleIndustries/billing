package com.multiple.common.service;

import com.multiple.common.model.mail.EmailData;


public interface SendMailService {
	public void sendMail(final EmailData data);
}
