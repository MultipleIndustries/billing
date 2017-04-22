package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class DuplicateStateException extends BusinessException{
	
	
	public DuplicateStateException() {
		super(CustomException.DUPLICATE_STATE.getCode());
	}

	public DuplicateStateException(String errorCode){
		super(errorCode);
	}
	 
}
