package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class DuplicateAreaException extends BusinessException{
	
	
	public DuplicateAreaException() {
		super(CustomException.DUPLICATE_AREA.getCode());
	}

	public DuplicateAreaException(String errorCode){
		super(errorCode);
	}
	 
}
