package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.EmailTemplate;
import com.multiple.common.repository.EmailTemplateRepository;
import com.multiple.common.service.EmailTemplateService;

@Service
public class EmailTemplateServiceImpl implements EmailTemplateService{

	@Autowired
	private EmailTemplateRepository repository;
	
	@Override
	public List<EmailTemplate> findEmailTemplates() {
		return repository.findAll();
	}

	@Override
	public EmailTemplate findById(long id) {
		return repository.findOne(id);
	}

}
