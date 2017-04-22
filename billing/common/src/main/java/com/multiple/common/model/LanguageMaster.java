package com.multiple.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Audited
public class LanguageMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long languageId;

	@Column(unique = true, nullable = false, length = 75)
	@NotBlank(message="Please enter language name")
	@Size(max=75,message="Language name will be of maximum 75 character")
	private String languageName;

	@Column(unique = true, nullable = false, length = 10)
	@NotBlank(message="Please enter language short name")
	@Size(max=10,message="Language short name will be of maximum 10 character")
	private String shortName;

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(nullable = false,name="active_")
	private boolean active = true;
	
	@CreatedDate
	private DateTime createdOn;

	@LastModifiedDate
	private DateTime lastModifiedOn;

//	@JsonIgnore
//	@CreatedBy
//	@ManyToOne(fetch = FetchType.LAZY)
//	private User createdBy;
//
//	@JsonIgnore
//	@LastModifiedBy
//	@ManyToOne(fetch = FetchType.LAZY)
//	private User lastModifiedBy;
	
	public LanguageMaster() {
		super();
	}

	public LanguageMaster(String name, String shortName) {
		super();
		this.languageName = name;
		this.shortName = shortName;
	}

	public Long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Long languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

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

//	public User getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(User createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public User getLastModifiedBy() {
//		return lastModifiedBy;
//	}
//
//	public void setLastModifiedBy(User lastModifiedBy) {
//		this.lastModifiedBy = lastModifiedBy;
//	}
	
	

}
