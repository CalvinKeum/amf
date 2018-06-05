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

package com.liferay.amf.web.internal.setup;

import com.liferay.amf.constants.AMFSearchConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.service.ResourcePermissionLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
 */
@Component(immediate = true, service = SetupAMFRoles.class)
public class SetupAMFRoles {

	@Activate
	public void activate(BundleContext bundleContext) throws Exception {
		_bundle = bundleContext.getBundle();

		importRoles();
	}

	protected void addRole(String roleName) throws Exception {
		long companyId = _portal.getDefaultCompanyId();

		Role role = _roleLocalService.fetchRole(companyId, roleName);

		if (role == null) {
			int type = RoleConstants.TYPE_REGULAR;

			role = _roleLocalService.addRole(
				_userLocalService.getDefaultUserId(companyId), null, 0,
				roleName, null, null, type, null, null);
		}
	}

	protected void importRoles() throws Exception {
		for (String roleName : _ROLE_NAMES) {
			addRole(roleName);
		}
	}

	private static final String[] _ROLE_NAMES =
		{AMFSearchConstants.AMF_TEC_ROLE};

	private Bundle _bundle;

	@Reference
	private Portal _portal;

	@Reference
	private ResourcePermissionLocalService _resourcePermissionLocalService;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserLocalService _userLocalService;

}