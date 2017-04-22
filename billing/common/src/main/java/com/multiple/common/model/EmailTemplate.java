package com.multiple.common.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
public class EmailTemplate {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="EMAILTEMP_SEQ")
	@SequenceGenerator(name = "EMAILTEMP_SEQ", sequenceName = "EMAILTEMP_SEQ", allocationSize = 1, initialValue = 1)
	private Long id;
	
	private String templateName;
	
	private String templatePath;
	
	@Lob
	private String terms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getTerms() {
		return terms;
	}

	public void setTerms(String terms) {
		this.terms = terms;
	}
	
	
}
