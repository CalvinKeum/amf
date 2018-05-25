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

package com.liferay.amf.service.impl;

import com.liferay.amf.service.base.AMFTrackEventEntryServiceBaseImpl;
import com.liferay.amf.model.AMFTrackEventEntry;
import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.amf.service.permission.AMFTrackEventEntryPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.amf.constants.AMFTrackEventEntryActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
 */
public class AMFTrackEventEntryServiceImpl
	extends AMFTrackEventEntryServiceBaseImpl {

	@Override
	public List<AMFTrackEventEntry> getAMFTrackEventEntries(
			ServiceContext serviceContext, int start, int end)
		throws PortalException {

		if (hasPermission(serviceContext.getScopeGroupId())) {
			return amfTrackEventEntryLocalService.getAMFTrackEventEntries(
				start, end);
		}

		return amfTrackEventEntryLocalService.getAMFTrackEventEntries(
			serviceContext.getUserId(), start, end);
	}

	@Override
	public List<AMFTrackEventEntry> getAMFTrackEventEntries(
			ServiceContext serviceContext, int type, int start, int end)
		throws PortalException {

		if (hasPermission(serviceContext.getScopeGroupId())) {
			return amfTrackEventEntryLocalService.getAMFTrackEventEntries(
				type, start, end);
		}

		return amfTrackEventEntryLocalService.getAMFTrackEventEntries(
			serviceContext.getUserId(), type, start, end);
	}

	@Override
	public int getAMFTrackEventEntryCount(ServiceContext serviceContext)
		throws PortalException {

		if (hasPermission(serviceContext.getScopeGroupId())) {
			return
				amfTrackEventEntryLocalService.getAMFTrackEventEntriesCount();
		}

		return amfTrackEventEntryLocalService.count(serviceContext.getUserId());
	}

	@Override
	public int getAMFTrackEventEntryCount(
			ServiceContext serviceContext, int type)
		throws PortalException {

		if (hasPermission(serviceContext.getScopeGroupId())) {
			return amfTrackEventEntryLocalService.count(type);
		}

		return amfTrackEventEntryLocalService.count(
			serviceContext.getUserId(), type);
	}

	protected boolean hasPermission(long groupId) throws PortalException {
		return AMFTrackEventEntryPermission.contains(
			getPermissionChecker(), groupId, AMFPortletKeys.AMF_MONITOR,
			AMFTrackEventEntryActionKeys.VIEW_ALL_ENTRIES);
	}

}



