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

package com.liferay.amf.web.internal.display.context;

import com.liferay.amf.constants.AMFTrackEventEntryConstants;
import com.liferay.amf.model.AMFTrackEventEntry;
import com.liferay.amf.service.AMFTrackEventEntryServiceUtil;
import com.liferay.amf.web.internal.display.context.util.AMFMonitorRequestHelper;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.text.DateFormat;
import java.text.Format;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Calvin Keum
 */
public class DefaultAMFMonitorDisplayContext
	implements AMFMonitorDisplayContext {

	public DefaultAMFMonitorDisplayContext(
		AMFMonitorRequestHelper amfMonitorRequestHelper,
		HttpServletRequest request) {

		_amfMonitorRequestHelper = amfMonitorRequestHelper;
		_request = request;
	}

	@Override
	public Format getDateFormatDate() {
		ThemeDisplay themeDisplay = _amfMonitorRequestHelper.getThemeDisplay();

		return FastDateFormatFactoryUtil.getDate(
			DateFormat.FULL, themeDisplay.getLocale(),
			themeDisplay.getTimeZone());
	}

	@Override
	public int getPageDelta() {
		PortletPreferences portletPreferences =
			_amfMonitorRequestHelper.getPortletPreferences();

		return GetterUtil.getInteger(
			portletPreferences.getValue(
				"pageDelta", String.valueOf(SearchContainer.DEFAULT_DELTA)));
	}

	@Override
	public String getTabs1Names() {
		String tabs1Names = "all,login,registration";

		return tabs1Names;
	}

	@Override
	public String getTabs1PortletURL() {
		LiferayPortletResponse liferayPortletResponse =
			_amfMonitorRequestHelper.getLiferayPortletResponse();

		PortletURL tabs1URL = liferayPortletResponse.createRenderURL();

		tabs1URL.setParameter("mvcRenderCommandName", "/amf_monitor/view");
		tabs1URL.setParameter("tabs1", _amfMonitorRequestHelper.getTabs1());

		return tabs1URL.toString();
	}

	@Override
	public UUID getUuid() {
		return _UUID;
	}

	@Override
	public boolean isShowAllTrackEventEntries() {
		String tabs1 = _amfMonitorRequestHelper.getTabs1();

		return tabs1.equals("all");
	}

	@Override
	public boolean isShowLoginTrackEventEntries() {
		String tabs1 = _amfMonitorRequestHelper.getTabs1();

		return tabs1.equals("login");
	}

	@Override
	public boolean isShowRegistrationTrackEventEntries() {
		String tabs1 = _amfMonitorRequestHelper.getTabs1();

		return tabs1.equals("registration");
	}

	@Override
	public void populateResultsAndTotal(SearchContainer searchContainer)
		throws PortalException {

		int total = 0;
		List<AMFTrackEventEntry> results = new ArrayList<>();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			_request);

		if (isShowLoginTrackEventEntries()) {
			total = AMFTrackEventEntryServiceUtil.getAMFTrackEventEntryCount(
				serviceContext, AMFTrackEventEntryConstants.TYPE_LOGIN);

			results = AMFTrackEventEntryServiceUtil.getAMFTrackEventEntries(
				serviceContext, AMFTrackEventEntryConstants.TYPE_LOGIN,
				searchContainer.getStart(), searchContainer.getEnd());
		}
		else if (isShowRegistrationTrackEventEntries()) {
			total = AMFTrackEventEntryServiceUtil.getAMFTrackEventEntryCount(
				serviceContext, AMFTrackEventEntryConstants.TYPE_REGISTRATION);

			results = AMFTrackEventEntryServiceUtil.getAMFTrackEventEntries(
				serviceContext, AMFTrackEventEntryConstants.TYPE_REGISTRATION,
				searchContainer.getStart(), searchContainer.getEnd());
		}
		else {
			total = AMFTrackEventEntryServiceUtil.getAMFTrackEventEntryCount(
				serviceContext);

			results = AMFTrackEventEntryServiceUtil.getAMFTrackEventEntries(
				serviceContext, searchContainer.getStart(),
				searchContainer.getEnd());
		}

		searchContainer.setTotal(total);
		searchContainer.setResults(results);
	}

	private static final UUID _UUID = UUID.fromString(
		"CD705D0E-7DB4-430C-9492-F1FA25ACE02E");

	private final AMFMonitorRequestHelper _amfMonitorRequestHelper;
	private final HttpServletRequest _request;

}