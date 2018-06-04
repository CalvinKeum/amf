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

package com.liferay.amf.web.internal.portlet;

import com.liferay.amf.constants.AMFPortletKeys;
import com.liferay.amf.web.internal.display.context.AMFMonitorDisplayContext;
import com.liferay.amf.web.internal.display.context.DefaultAMFMonitorDisplayContext;
import com.liferay.amf.web.internal.display.context.util.AMFMonitorRequestHelper;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Calvin Keum
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.tools",
		"javax.portlet.display-name=AMF Monitor",
		"javax.portlet.init-param.copy-request-parameters=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/amf_monitor/view.jsp",
		"javax.portlet.name=" + AMFPortletKeys.AMF_MONITOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AMFMonitorPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(
			renderRequest);

		AMFMonitorRequestHelper amfMonitorRequestHelper =
			new AMFMonitorRequestHelper(servletRequest);

		AMFMonitorDisplayContext amfMonitorDisplayContext =
			new DefaultAMFMonitorDisplayContext(
				amfMonitorRequestHelper, servletRequest);

		PortletURL portletURL = renderResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/amf_monitor/view");
		portletURL.setParameter("tabs1", amfMonitorRequestHelper.getTabs1());

		SearchContainer searchContainer = new SearchContainer(
			renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM,
			amfMonitorDisplayContext.getPageDelta(), portletURL, null,
			"there-are-no-entries");

		try {
			amfMonitorDisplayContext.populateResultsAndTotal(searchContainer);
		}
		catch (Exception e) {
		}

		renderRequest.setAttribute(
			"amfMonitorDisplayContext", amfMonitorDisplayContext);
		renderRequest.setAttribute("searchContainer", searchContainer);

		super.render(renderRequest, renderResponse);
	}

}