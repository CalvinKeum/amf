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

import com.liferay.amf.constants.AMFTrackEventEntryConstants;
import com.liferay.amf.exception.TrackEventEntryIpAddressException;
import com.liferay.amf.exception.TrackEventEntryTypeException;
import com.liferay.amf.model.AMFTrackEventEntry;
import com.liferay.amf.service.base.AMFTrackEventEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * @author Calvin Keum
 */
public class AMFTrackEventEntryLocalServiceImpl
	extends AMFTrackEventEntryLocalServiceBaseImpl {

	@Override
	public AMFTrackEventEntry addTrackEventEntry(
			long userId, int type, String ipAddress)
		throws PortalException {

		validate(userId, type, ipAddress);

		User user = userLocalService.getUser(userId);

		long amfTrackEventEntryId = counterLocalService.increment();

		AMFTrackEventEntry amfTrackEventEntry =
			amfTrackEventEntryPersistence.create(amfTrackEventEntryId);

		amfTrackEventEntry.setCreateDate(new Date());
		amfTrackEventEntry.setUserName(user.getScreenName());
		amfTrackEventEntry.setUserId(userId);
		amfTrackEventEntry.setType(type);
		amfTrackEventEntry.setIpAddress(ipAddress);

		amfTrackEventEntryPersistence.update(amfTrackEventEntry);

		return amfTrackEventEntry;
	}

	@Override
	public int count(int type) throws PortalException {
		return amfTrackEventEntryPersistence.countByType(type);
	}

	@Override
	public int count(long userId) throws PortalException {
		return amfTrackEventEntryPersistence.countByUserId(userId);
	}

	@Override
	public int count(long userId, int type) throws PortalException {
		return amfTrackEventEntryPersistence.countByU_T(userId, type);
	}

	@Override
	public List<AMFTrackEventEntry> getAMFTrackEventEntries(
			int type, int start, int end)
		throws PortalException {

		return amfTrackEventEntryPersistence.findByType(type, start, end);
	}

	@Override
	public List<AMFTrackEventEntry> getAMFTrackEventEntries(
			long userId, int start, int end)
		throws PortalException {

		return amfTrackEventEntryPersistence.findByUserId(userId, start, end);
	}

	@Override
	public List<AMFTrackEventEntry> getAMFTrackEventEntries(
			long userId, int type, int start, int end)
		throws PortalException {

		return amfTrackEventEntryPersistence.findByU_T(
			userId, type, start, end);
	}

	protected void validate(long userId, int type, String ipAddress)
		throws PortalException {

		userLocalService.getUser(userId);

		String typeLabel = AMFTrackEventEntryConstants.getEventTypeLabel(type);

		if (Validator.isNull(typeLabel)) {
			throw new TrackEventEntryTypeException(
				"Invalid track event entry type " + type);
		}

		if (!Validator.isIPAddress(ipAddress)) {
			throw new TrackEventEntryIpAddressException(
				"Invalid track event entry ip address " + ipAddress);
		}
	}

}