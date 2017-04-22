package com.multiple.common.concurrency;

import com.multiple.kernel.exception.BusinessException;


public class RecordLockedException extends BusinessException {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	private LockDetails lockDetails;

	public LockDetails getLockDetails() {
		return lockDetails;
	}

	
	public String getErrorCode() {
		return errorCode;
	}


	public RecordLockedException(LockDetails lockDetails, String errorCode) {
		this.lockDetails = lockDetails;
		this.errorCode = errorCode;
	}
}
