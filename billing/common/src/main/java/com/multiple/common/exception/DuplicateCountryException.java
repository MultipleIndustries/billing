package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class DuplicateCountryException extends BusinessException{
	
	
	public DuplicateCountryException() {
		super(CustomException.DUPLICATE_COUNTRY.getCode());
	}

	public DuplicateCountryException(String errorCode){
		super(errorCode);
	}
	 
}
