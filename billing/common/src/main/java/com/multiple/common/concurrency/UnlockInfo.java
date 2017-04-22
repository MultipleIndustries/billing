package com.multiple.common.concurrency;

import java.util.Date;
import com.multiple.common.model.User;

public class UnlockInfo {

	private User owner;
	private String transactionType;
	private long transactionId;
	private Date createdOn;
	private String transactionDisplayNo;

	public UnlockInfo() {
	}

//	public UnlockInfo(LockDetails lockDetails, String transactionDisplayNo) {
//		this.owner = lockDetails.getOwner();
//		this.transactionType = lockDetails.getTransactionType();
//		this.transactionId = lockDetails.getTransactionId();
//		this.createdOn = lockDetails.getCreatedOn();
//		this.transactionDisplayNo = transactionDisplayNo;
//	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getTransactionDisplayNo() {
		return transactionDisplayNo;
	}

	public void setTransactionDisplayNo(String transactionDisplayNo) {
		this.transactionDisplayNo = transactionDisplayNo;
	}

}
