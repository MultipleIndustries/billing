/**
 * Copyright (c) 2014 Astrika, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

/**
 * @author Priyanka
 */
public class UserPortraitTypeException extends BusinessException {

	public UserPortraitTypeException() {
		super(CustomException.USER_PORTRAIT_TYPE_EXCEPTION.getCode());
	}

	public UserPortraitTypeException(String msg) {
		super(msg);
	}

	public UserPortraitTypeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserPortraitTypeException(Throwable cause) {
		super(cause);
	}

}