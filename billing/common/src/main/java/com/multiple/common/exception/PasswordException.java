package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;


public class PasswordException extends BusinessException{
	
	public PasswordException() {
		super(CustomException.PASSWORD_EXCEPTION.getCode());
	}

	public PasswordException(String errorCode){
		super(errorCode);
	}
}
