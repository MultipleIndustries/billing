
package com.multiple.common.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import com.multiple.common.model.Role;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.JoinColumn;
/**
 * @author Priyanka
 */
@Entity
@Audited
@Table(name = "User_Detail")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQUENCE_NAME")
	@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
	private Long userId;
	
	@Column(unique = true, length = 16)
	private String uuId = null;

	@Column(length = 75)
	private String firstName = "";
	
	
	@Column(length = 75)
	private String middleName ="";
	
	@Column(length = 75)
	private String lastName ="";
	
	@Column(length = 75)
	private String gender ="";
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	private Boolean residentType;
	
	@Column
	private Date dateofBirth;
	
	@Transient
	private String dateOfBirthStr;
	
	@Column
	private String emailId;
	
	@Column(unique=true)
	private String mobile;
	
	@Column(length =12)
	private Integer aadharCardNumber;
	
	@Column(length = 10)
	private String panCardNumber;
	
	private Date registerationDate;
	
	@Type(type= "org.hibernate.type.NumericBooleanType")
	private Boolean disclaimer;
	
	@Transient
	private Integer loanType;
	
	@Column(length = 75)
	private String password = "";
	
	@Column
	private Date passExpiryDate;

	
	public Date getPassExpiryDate() {
		return passExpiryDate;
	}

	public void setPassExpiryDate(Date passExpiryDate) {
		this.passExpiryDate = passExpiryDate;
	}

	@Transient
	private Collection<? extends GrantedAuthority> grantedAuthorities;

	private String macId;
	/*
	 * User Role 0 - Astrika/Super Admin 1 - Gourmet 7 Admin 2 - Company Admin 3
	 * - Brand Admin 4 - Outlet Admin 5 - Corporate 6 - Member
	 */
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	

	/*

	/*
	 * User Role 0 - Inactive 1 - Active
	 */
	/*@Enumerated(EnumType.ORDINAL)
	private UserStatus status;

	*/
	
	@Column
	private Date loginDate;

	@Column
	private Date lastLoginDate;

/*	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean emailAddressVerified;

	@ManyToOne
	private StateMaster state;

	@Column(length = 525)
	private String address;

	@Column(columnDefinition = "boolean default true", nullable = false)
	private boolean active = true;

	
*/
	@Transient
	private String fullName;
	
	
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

	private String token;
	
	
	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(
			Collection<? extends GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	@Override
	public String getUsername() {
		return this.getMobile();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public String getMacId() {
		return macId;
	}

	public void setMacId(String macId) {
		this.macId = macId;
	}

	public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	/*public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}



	/*public StateMaster getState() {
		return state;
	}

	public void setState(StateMaster state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
*/
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



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

	public String getMobile() {
		return mobile;
	}


	public String getPassword() {
		return password;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
	public Date getLoginDate() {
		return loginDate;
	}


	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	public String getUuId() {
		return uuId;
	}


	public void setUuId(String uuId) {
		this.uuId = uuId;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Integer getAadharCardNumber() {
		return aadharCardNumber;
	}


	public void setAadharCardNumber(Integer aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}


	public String getPanCardNumber() {
		return panCardNumber;
	}


	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public Boolean getResidentType() {
		return residentType;
	}


	public void setResidentType(Boolean residentType) {
		this.residentType = residentType;
	}


	public Date getRegisterationDate() {
		return registerationDate;
	}


	public void setRegisterationDate(Date registerationDate) {
		this.registerationDate = registerationDate;
	}


	public Boolean getDisclaimer() {
		return disclaimer;
	}


	public void setDisclaimer(Boolean disclaimer) {
		this.disclaimer = disclaimer;
	}


	public Integer getLoanType() {
		return loanType;
	}


	public void setLoanType(Integer loanType) {
		this.loanType = loanType;
	}

	public String getDateOfBirthStr() {
		return dateOfBirthStr;
	}

	public void setDateOfBirthStr(String dateOfBirthStr) {
		this.dateOfBirthStr = dateOfBirthStr;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
