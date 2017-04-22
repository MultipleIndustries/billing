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
public class CityMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CITY_SEQ")
	@SequenceGenerator(name = "CITY_SEQ", sequenceName = "CITY_SEQ", allocationSize = 1, initialValue = 1)
	private Long cityId;

	@Column(nullable = false, length = 75)
	private String cityName;

	@Type(type= "org.hibernate.type.NumericBooleanType")
	@Column(nullable = false,name="active_")
	private boolean active = true;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private CountryMaster country;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private StateMaster state;

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

	public CityMaster() {
		super();
	}

	public CityMaster(String cityName, CountryMaster country) {
		super();
		this.cityName = cityName;
		this.country = country;
	}

	public CityMaster(String cityName, StateMaster state, CountryMaster country) {
		super();
		this.cityName = cityName;
		this.state = state;
		this.country = country;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public CountryMaster getCountry() {
		return country;
	}

	public void setCountry(CountryMaster country) {
		this.country = country;
	}

	// public static String getOffSet(String timZone){
	// int offset = TimeZone.getTimeZone(timZone).getRawOffset();
	// int offsetHrs = offset / 1000 / 60 / 60;
	// int offsetMins = offset / 1000 / 60 % 60;
	//
	// if(offsetHrs != 0 && offsetHrs > 0){
	// return "GMT+"+offsetHrs+":"+(offsetMins==0?"00":offsetMins);
	// }
	// else if(offsetHrs != 0 && offsetHrs < 0){
	// return "GMT"+offsetHrs+":"+(offsetMins==0?"00":offsetMins);
	// }
	// else if(offsetMins != 0 && offsetMins > 0){
	// return "GMT+"+offsetHrs+":"+offsetMins;
	// }
	// else if(offsetMins != 0 && offsetMins < 0){
	// return "GMT-"+offsetHrs+":"+(offsetMins<0?-offsetMins:offsetMins);
	// }
	// else{
	// return "GMT";
	// }
	// }

	public StateMaster getState() {
		return state;
	}

	public void setState(StateMaster state) {
		this.state = state;
	}

	public static String getOffSet(String timZone) {
		if (timZone != null && timZone.length() > 0) {
			return timZone.substring(timZone.indexOf("(") + 1,
					timZone.indexOf(')'));
		} else
			return "UTC";

	}
}
