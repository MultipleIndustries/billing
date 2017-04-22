package com.multiple.common.model.location;

//import com.multiple.common.model.CurrencyMaster;
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
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Audited
public class CountryMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="COUNTRY_SEQ")
	@SequenceGenerator(name = "COUNTRY_SEQ", sequenceName = "COUNTRY_SEQ", allocationSize = 1, initialValue = 1)
	private Long countryId;

	@Column(unique = true, nullable = false, length = 75)
	private String countryName;

//	@JsonIgnore
//	@ManyToOne(fetch=FetchType.LAZY)
//	private CurrencyMaster currency;

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(nullable = false,name="active_")
	private boolean active = true;

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
	@IndexColumn(name="")
	private User lastModifiedBy;

	public CountryMaster() {
		super();
	}

//	public CountryMaster(String countryName, CurrencyMaster currency) {
//		super();
//		this.countryName = countryName;
////		this.currency = currency;
//	}
	
	public CountryMaster(String countryName) {
	super();
	this.countryName = countryName;
}


	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	@JsonIgnore
	public User getCreatedBy() {
		return createdBy;
	}

	@JsonIgnore
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	@JsonIgnore
	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
//	@JsonIgnore
//	public CurrencyMaster getCurrency() {
//		return currency;
//	}
//	@JsonIgnore
//	public void setCurrency(CurrencyMaster currency) {
//		this.currency = currency;
//	}

}
