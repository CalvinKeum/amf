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

package com.liferay.amf.service.permission;

import com.liferay.amf.model.AMFTrackEventEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Calvin Keum
 */
/*
@Component(
	immediate = true,
	property = "resource.name=" + AMFTrackEventEntryPermission.RESOURCE_NAME,
	service = ResourcePermissionChecker.class
)
*/
public class AMFTrackEventEntryPermission {
	//extends BaseResourcePermissionChecker {
	//CalendarPortletPermission
/*
	public static final String RESOURCE_NAME = "com.liferay.amf";

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}
*/
	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String portletId, 
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, portletId, portletId, actionId);
	}

	/*
	public static boolean containsPortletPermission(
		PermissionChecker permissionChecker, long groupId, String portletId,
		String actionId) {

		return permissionChecker.hasPermission(
			groupId, portletId, portletId, actionId);
	}
	*/
/*
	@Override
	public Boolean checkResource(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		return contains(permissionChecker, classPK, actionId);
	}
*/
}
