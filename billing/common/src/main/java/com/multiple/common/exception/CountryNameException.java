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
public class CountryNameException extends BusinessException {

	public CountryNameException() {
		super(CustomException.COUNTRY_NAME_EXCEPTION.getCode());
	}

	public CountryNameException(String msg) {
		super(msg);
	}

	public CountryNameException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CountryNameException(Throwable cause) {
		super(cause);
	}

}