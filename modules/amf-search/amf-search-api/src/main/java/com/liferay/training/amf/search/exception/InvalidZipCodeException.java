/*
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.training.amf.search.exception;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author William Strong
 */
@ProviderType
public class InvalidZipCodeException extends PortalException {

	public InvalidZipCodeException() {
	}

	public InvalidZipCodeException(String msg) {
		super(msg);
	}

	public InvalidZipCodeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public InvalidZipCodeException(Throwable cause) {
		super(cause);
	}

	public static class NotANumber extends InvalidZipCodeException {

		public NotANumber() {
		}

	}

	public static class Null extends InvalidZipCodeException {

		public Null() {
		}

	}

	public static class TooFewDigits extends InvalidZipCodeException {

		public TooFewDigits() {
		}

	}

	public static class TooManyDigits extends InvalidZipCodeException {

		public TooManyDigits() {
		}

	}

}