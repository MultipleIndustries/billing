package com.multiple.common.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.envers.Audited;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Audited
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long billId;
	
	@Column(nullable = true, length = 75)
	private String contractorNumber;
	
	@Column(nullable = true, length = 75)
	private String contractorCategory;
	
	@Column(nullable = true, length = 75)
	private String sheetNumber;
	
	@Column(nullable = true, length = 75)
	private String buildingName;
	
	@Column(nullable = true, length = 75)
	private String job;

	public String getContractorNumber() {
		return contractorNumber;
	}

	public void setContractorNumber(String contractorNumber) {
		this.contractorNumber = contractorNumber;
	}

	public String getContractorCategory() {
		return contractorCategory;
	}

	public void setContractorCategory(String contractorCategory) {
		this.contractorCategory = contractorCategory;
	}

	public String getSheetNumber() {
		return sheetNumber;
	}

	public void setSheetNumber(String sheetNumber) {
		this.sheetNumber = sheetNumber;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	private Customer customer;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<ProductMaster> product;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<VariantMaster> variant;
	
	
	public List<ProductMaster> getProduct() {
		return product;
	}

	public void setProduct(List<ProductMaster> product) {
		this.product = product;
	}

	public List<VariantMaster> getVariant() {
		return variant;
	}

	public void setVariant(List<VariantMaster> variant) {
		this.variant = variant;
	}

	@Column(nullable = false, length = 75)
	private double length;
	
	@Column(nullable = false, length = 75)
	private double width;
	
	@Column(nullable = false, length = 75)
	private double area;

	@Column(nullable = false, length = 75)
	private double rate;
	
	@Column(nullable = false, length = 75)
	private double amount;
	
	@Column(nullable = true, length = 75)
	private double balance;
	
	@Column(nullable = true, length = 75)
	private double vatPercent;
	
	@Column(nullable = true, length = 75)
	private double vatAmount;
	
	@Column(nullable = true, length = 75)
	private double servicePercent;
	
	@Column(nullable = true, length = 75)
	private double serviceAmount;
	
	@Column(nullable = false, length = 75)
	private double totalAmount;
	
	@Column(nullable = true, length = 75)
	private String status;
	
	@CreatedDate
	private DateTime createdOn;

	@LastModifiedDate
	private DateTime lastModifiedOn;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getVatPercent() {
		return vatPercent;
	}

	public void setVatPercent(double vatPercent) {
		this.vatPercent = vatPercent;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public double getServicePercent() {
		return servicePercent;
	}

	public void setServicePercent(double servicePercent) {
		this.servicePercent = servicePercent;
	}

	public double getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(double serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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


}
