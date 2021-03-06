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

package com.liferay.amf.web.internal.portlet.action;

import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.amf.constants.AMFSearchConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

/**
 * @author Calvin Keum
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_SEARCH,
		"mvc.command.name=/amf_search/search"
	}
)
public class SearchMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortletException {

		String searchZip = ParamUtil.getString(actionRequest, "searchZip");

		if (!Validator.isDigit(searchZip) ||
			(searchZip.length() != AMFSearchConstants.MAX_ZIP_LENGTH)) {

			SessionErrors.add(actionRequest, "zipCodeInvalid");

			return false;
		}

		actionResponse.setRenderParameter("searchZip", searchZip);

		return true;
	}

}