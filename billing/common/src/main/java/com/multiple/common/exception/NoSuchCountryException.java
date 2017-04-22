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

import com.multiple.kernel.exception.CustomException;

/**
 * @author Priyanka
 */
public class NoSuchCountryException extends NoSuchModelException {

	public NoSuchCountryException() {
		super(CustomException.NO_SUCH_COUNTRY.getCode());
	}

	public NoSuchCountryException(String msg) {
		super(msg);
	}

	public NoSuchCountryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCountryException(Throwable cause) {
		super(cause);
	}

}