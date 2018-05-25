<%--
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
--%>

<%@ include file="/amf_monitor/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcRenderCommandName", "/amf_monitor/view");
portletURL.setParameter("tabs1", amfMonitorRequestHelper.getTabs1());

ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);

SearchContainer aMFMonitorSearchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, amfMonitorDisplayContext.getPageDelta(), portletURL, null, "there-are-no-entries");
%>

<c:if test="<%= amfMonitorDisplayContext.isTabs1Visible() %>">
	<liferay-ui:tabs
		names="<%= amfMonitorDisplayContext.getTabs1Names() %>"
		type="tabs nav-tabs-default"
		url="<%= amfMonitorDisplayContext.getTabs1PortletURL() %>"
	/>
</c:if>

<c:choose>
	<c:when test="<%= amfMonitorDisplayContext.isShowLoginTrackEventEntries() %>">
		<%@ include file="/amf_monitor/login_event_entries.jspf" %>
	</c:when>
	<c:when test="<%= amfMonitorDisplayContext.isShowRegistrationTrackEventEntries() %>">
		<%@ include file="/amf_monitor/registration_event_entries.jspf" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/amf_monitor/all_event_entries.jspf" %>
	</c:otherwise>
</c:choose>