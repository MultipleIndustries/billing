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
//@JsonSerialize
public class AreaMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="AREA_SEQ")
	@SequenceGenerator(name = "AREA_SEQ", sequenceName = "AREA_SEQ", allocationSize = 1, initialValue = 1)
	private Long areaId;

	@Column(nullable = false, length = 75)
	private String areaName;

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(nullable = false,name="active_")
	private boolean active = true;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private CityMaster city;

	@JsonIgnore
	@ManyToOne(fetch =FetchType.LAZY)
	private CountryMaster country;

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

	@Column(nullable = false)
	private double latitude;

	@Column(nullable = false)
	private double longitude;

	public AreaMaster() {
		super();
	}

	public AreaMaster(String areaName, CityMaster city, CountryMaster country,
			double latitude, double longitude) {
		super();
		this.areaName = areaName;
		this.city = city;
		this.country = country;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public CityMaster getCity() {
		return city;
	}

	public void setCity(CityMaster city) {
		this.city = city;
	}
	@JsonIgnore
	public CountryMaster getCountry() {
		return country;
	}
	@JsonIgnore
	public void setCountry(CountryMaster country) {
		this.country = country;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
