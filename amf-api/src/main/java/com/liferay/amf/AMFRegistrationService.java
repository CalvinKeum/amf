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

package com.liferay.amf;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;

/**
 * @author Calvin Keum
 */
public interface AMFRegistrationService {

	public void createAccount(
			ThemeDisplay themeDisplay, String username, String emailAddress,
			String firstName, String lastName, boolean male, int birthdayMonth,
			int birthdayDay, int birthdayYear, String password1,
			String password2, String securityQuestion, String securityAnswer,
			boolean acceptedTOU, String homePhone, String mobilePhone,
			String address, String address2, String city, String state,
			String zip, ServiceContext userServiceContext,
			ServiceContext phoneServiceContext,
			ServiceContext addressServiceContext)
		throws Exception;

}