package com.multiple.common.model.location;

import com.multiple.common.model.User;

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
public class StateMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="COUNTRY_SEQ")
	@SequenceGenerator(name = "COUNTRY_SEQ", sequenceName = "COUNTRY_SEQ", allocationSize = 1, initialValue = 1)
	private Long stateId;    
	
	
	@Column(nullable = false, length = 75)
	private String stateName;    
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CountryMaster country;  
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(nullable = false,name="active_")
	private boolean active=true;
	
	@CreatedDate
	private DateTime createdOn;
	
	@JsonIgnore
	@CreatedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User createdBy;   
	
	@LastModifiedDate
	private DateTime lastModifiedOn;
	
	@JsonIgnore
	@LastModifiedBy
	@ManyToOne(fetch = FetchType.LAZY)
	private User lastModifiedBy;

	
	
	public StateMaster()
	{
		super();
	}
	
	public StateMaster(String stateName, CountryMaster country)
	{
		super();
		this.stateName = stateName;
		this.country = country;
	}
	

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	public CountryMaster getCountry() {
		return country;
	}

	public void setCountry(CountryMaster country) {
		this.country = country;
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

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getLastModifiedOn() {
		return lastModifiedOn;
	}

	public void setLastModifiedOn(DateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	} 
	

}
