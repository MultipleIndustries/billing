package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;


public class DuplicateLoginException extends BusinessException{
	
	
	public DuplicateLoginException() {
		super(CustomException.DUPLICATE_LOGIN.getCode());
	}

	public DuplicateLoginException(String errorCode){
		super(errorCode);
	}
}
