package com.multiple.common.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Audited
public class SMSDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SMS_SEQ")
	@SequenceGenerator(name = "SMS_SEQ", sequenceName = "SMS_SEQ", allocationSize = 1, initialValue = 1)
	private Long smsId;
			
	@Column(length = 10)
	private String mobileno = "";
	
	@Column(length = 255)
	private String messagetext ="";
	
	@Column
	private Date messagedate ;
	
	@Column
	private String status;
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column
	private Boolean verified;
	
	@CreatedDate
	private DateTime createdOn;
	
	
	@LastModifiedDate
	private DateTime lastModifiedOn;

	@JsonIgnore
	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdBy;
	
	@JsonIgnore
	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User lastModifiedBy;


	

	public DateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(DateTime createdOn) {
		this.createdOn = createdOn;
	}

	public DateTime getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(DateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getSmsId() {
		return smsId;
	}

	public void setSmsId(Long smsId) {
		this.smsId = smsId;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public Date getMessagedate() {
		return messagedate;
	}

	public void setMessagedate(Date messagedate) {
		this.messagedate = messagedate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}
	
	
	
}
