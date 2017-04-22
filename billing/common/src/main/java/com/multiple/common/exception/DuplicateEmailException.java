package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;


public class DuplicateEmailException extends BusinessException{
	
	
	public DuplicateEmailException() {
		super(CustomException.DUPLICATE_EMAIL.getCode());
	}

	public DuplicateEmailException(String errorCode){
		super(errorCode);
	}
}
