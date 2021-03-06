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

<liferay-ui:tabs
	names="${amfMonitorDisplayContext.tabs1Names}"
	type="tabs nav-tabs-default"
	url="${amfMonitorDisplayContext.tabs1PortletURL}"
/>

<liferay-ui:search-container
	searchContainer="${searchContainer}"
	total="${searchContainer.total}"
>
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.amf.model.AMFTrackEventEntry"
		escapedModel="<%= true %>"
		keyProperty="amfTrackEventEntryId"
		modelVar="amfTrackEventEntry"
	>
		<liferay-ui:search-container-column-text
			name="occurredDate"
			value="<%= amfTrackEventEntry.getCreateDateDisplayHTML() %>"
		/>

		<liferay-ui:search-container-column-text
			name="user"
			value="<%= amfTrackEventEntry.getUserNameIdDisplayHTML() %>"
		/>

		<liferay-ui:search-container-column-text
			name="ipAddress"
			property="ipAddress"
		/>

		<liferay-ui:search-container-column-text
			name="type"
		>
			<%= LanguageUtil.get(request, amfTrackEventEntry.getTypeLabelDisplayHTML()) %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>