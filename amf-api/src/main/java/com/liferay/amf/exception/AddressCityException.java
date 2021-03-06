/**
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

package com.liferay.amf.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Calvin Keum
 */
public class AddressCityException extends PortalException {

	public static class MaxLength extends AddressCityException {

		public MaxLength(int maxLength) {
			super(
				String.format(
					"City address must not be longer than %s characters",
					maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	public static class MustBeAlphanumeric extends AddressCityException {

		public MustBeAlphanumeric() {
			super("City address must only contain alphanumeric characters");
		}

	}

	public static class MustNotBeNull extends AddressCityException {

		public MustNotBeNull() {
			super("City address must not be null");
		}

	}

	private AddressCityException(String msg) {
		super(msg);
	}

}