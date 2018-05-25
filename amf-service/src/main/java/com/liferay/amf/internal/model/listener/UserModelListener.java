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

package com.liferay.amf.internal.model.listener;

import com.liferay.amf.constants.AMFTrackEventEntryConstants;
import com.liferay.amf.service.AMFTrackEventEntryLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
 */
@Component(immediate = true, service = ModelListener.class)
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onAfterCreate(User user) {
		try {
			_amfTrackEventEntryLocalService.addTrackEventEntry(
				user.getUserId(), AMFTrackEventEntryConstants.TYPE_REGISTRATION,
				AMFTrackEventEntryConstants.EMPTY_IP_ADDRESS);
		}
		catch (Exception e) {
			_log.error(
				"Unable to add track event entry for user " + user.getUserId());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		UserModelListener.class);

	@Reference
	private AMFTrackEventEntryLocalService _amfTrackEventEntryLocalService;

}