package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class DuplicateCityException extends BusinessException{
	
	
	public DuplicateCityException() {
		super(CustomException.DUPLICATE_CITY.getCode());
	}

	public DuplicateCityException(String errorCode){
		super(errorCode);
	}
	 
}
