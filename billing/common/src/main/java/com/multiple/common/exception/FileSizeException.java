package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

/**
 * @author Priyanka
 */
public class FileSizeException extends BusinessException {

	public FileSizeException() {
		super(CustomException.FILE_SIZE_EXCEPTION.getCode());
	}

	public FileSizeException(String msg) {
		super(msg);
	}

	public FileSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileSizeException(Throwable cause) {
		super(cause);
	}

}