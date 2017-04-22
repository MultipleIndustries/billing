package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class DuplicateCurrencyException extends BusinessException {
	
	
	public DuplicateCurrencyException() {
		super(CustomException.DUPLICATE_CURRENCY.getCode());
	}

	public DuplicateCurrencyException(String errorCode) {
		super(errorCode);
	}

}
