package com.multiple.common.service;

import java.util.List;

import com.multiple.common.model.EmailTemplate;

public interface EmailTemplateService {

	List<EmailTemplate> findEmailTemplates();
	
	EmailTemplate findById(long id);
}
