
package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;
/**
 * @author Priyanka
 */
public class FileNameException extends BusinessException {

	

	public FileNameException() {
		super(CustomException.DUPLICATE_FILE_NAME.getCode());
	}

	public FileNameException(String msg) {
		super(msg);
	}

	public FileNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileNameException(Throwable cause) {
		super(cause);
	}

}