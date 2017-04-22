
package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;
/**
 * @author Priyanka
 */
public class FileExtensionException extends BusinessException {

	public FileExtensionException() {
		super(CustomException.FILE_EXTENSION_NOT_SUPPORTED.getCode());
	}

	public FileExtensionException(String msg) {
		super(msg);
	}

	public FileExtensionException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FileExtensionException(Throwable cause) {
		super(cause);
	}

}