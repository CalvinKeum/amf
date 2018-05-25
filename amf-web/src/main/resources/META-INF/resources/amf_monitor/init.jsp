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

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.servlet.SessionMessages" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.dao.search.SearchContainer" %><%@
page import="com.liferay.amf.service.AMFTrackEventEntryLocalServiceUtil" %><%@
page import="com.liferay.amf.service.AMFTrackEventEntryServiceUtil" %><%@
page import="com.liferay.amf.web.internal.display.context.AMFMonitorDisplayContext" %><%@
page import="com.liferay.amf.web.internal.display.context.DefaultAMFMonitorDisplayContext" %><%@
page import="com.liferay.amf.constants.AMFTrackEventEntryConstants" %><%@
page import="com.liferay.portal.kernel.service.ServiceContext" %><%@
page import="com.liferay.portal.kernel.service.ServiceContextFactory" %><%@
page import="com.liferay.amf.web.internal.display.context.util.AMFMonitorRequestHelper" %>

<%@ page import="javax.portlet.PortletRequest" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<%@ page import="java.util.Calendar" %><%@
page import="java.util.Date" %>

<%
AMFMonitorRequestHelper amfMonitorRequestHelper = new AMFMonitorRequestHelper(request);
AMFMonitorDisplayContext amfMonitorDisplayContext = new DefaultAMFMonitorDisplayContext(amfMonitorRequestHelper);
%>