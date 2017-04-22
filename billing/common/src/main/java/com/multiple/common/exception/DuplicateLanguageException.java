package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class DuplicateLanguageException extends BusinessException {
	
	
	public DuplicateLanguageException() {
		super(CustomException.DUPLICATE_LANGUAGE.getCode());
	}

	public DuplicateLanguageException(String errorCode) {
		super(errorCode);
	}

}
