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

package com.liferay.amf.internal.events;

import com.liferay.amf.constants.AMFTrackEventEntryConstants;
import com.liferay.amf.service.AMFTrackEventEntryLocalService;
import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
 */
@Component(
	immediate = true, property = {"key=login.events.post"},
	service = LifecycleAction.class
)
public class LoginPostAction extends Action {

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {
		User user = (User)request.getAttribute(WebKeys.USER);

		try {
			_amfTrackEventEntryLocalService.addTrackEventEntry(
				user.getUserId(), AMFTrackEventEntryConstants.TYPE_LOGIN,
				request.getRemoteAddr());
		}
		catch (Exception e) {
			_log.error(
				"Unable to add track event entry for user " + user.getUserId());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		LoginPostAction.class);

	@Reference
	private AMFTrackEventEntryLocalService _amfTrackEventEntryLocalService;

}