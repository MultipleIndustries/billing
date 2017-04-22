package com.multiple.common.model.mail;

import java.util.HashMap;

public class EmailData {

	private String bcc;
	private String cc;
	private String to;
	private String mailTemplate;
	private String from;
	private HashMap<String, Object> model;
	private String subject;
	
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMailTemplate() {
		return mailTemplate;
	}
	public void setMailTemplate(String mailTemplate) {
		this.mailTemplate = mailTemplate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public HashMap<String, Object> getModel() {
		return model;
	}
	public void setModel(HashMap<String, Object> model) {
		this.model = model;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
