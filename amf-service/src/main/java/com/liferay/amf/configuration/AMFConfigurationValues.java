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

package com.liferay.amf.configuration;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * @author Calvin Keum
 */
public class AMFConfigurationValues {

	public static final int ADDRESS_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.ADDRESS_MAX_LENGTH));

	public static final int AGE_MIN = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.AGE_MIN));

	public static final int CITY_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.CITY_MAX_LENGTH));

	public static final int EMAIL_ADDRESS_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(
			AMFConfigurationKeys.EMAIL_ADDRESS_MAX_LENGTH));

	public static final int FIRST_NAME_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.FIRST_NAME_MAX_LENGTH));

	public static final int LAST_NAME_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.LAST_NAME_MAX_LENGTH));

	public static final int PASSWORD_MIN_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.PASSWORD_MIN_LENGTH));

	public static final int PHONE_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.PHONE_LENGTH));

	public static final int SECURITY_ANSWER_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(
			AMFConfigurationKeys.SECURITY_ANSWER_MAX_LENGTH));

	public static final int USERNAME_MAX_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.USERNAME_MAX_LENGTH));

	public static final int USERNAME_MIN_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.USERNAME_MIN_LENGTH));

	public static final int ZIP_LENGTH = GetterUtil.getInteger(
		AMFConfigurationUtil.get(AMFConfigurationKeys.ZIP_LENGTH));

}