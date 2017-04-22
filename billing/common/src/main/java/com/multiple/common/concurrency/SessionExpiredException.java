package com.multiple.common.concurrency;


public class SessionExpiredException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	private LockDetails lockDetails;

	public LockDetails getLockDetails() {
		return lockDetails;
	}

	
	public String getErrorCode() {
		return errorCode;
	}


	public SessionExpiredException( String errorCode) {
		this.errorCode = errorCode;
	}
}
