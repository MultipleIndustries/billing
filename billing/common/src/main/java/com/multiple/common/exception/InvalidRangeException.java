package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class InvalidRangeException extends BusinessException{
	
	public InvalidRangeException() {
		super(CustomException.INVALID_RANGE.getCode());
	}

	public InvalidRangeException(String errorCode){
		super(errorCode);
	}
	 
}
