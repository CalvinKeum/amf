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

<%@ include file="/amf_search/init.jsp" %>

<c:if test="${not empty search}">
	<h1><liferay-ui:message arguments="${search}" key="search-results-for-x" /></h1>

	<hr>
</c:if>

<liferay-ui:search-container
	searchContainer="${searchContainer}"
	total="${searchContainer.total}"
>
	<liferay-ui:search-container-results
		results="${searchContainer.results}"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.model.User"
		escapedModel="<%= true %>"
		keyProperty="userId"
		modelVar="user"
	>
		<liferay-ui:search-container-column-text>
			<%= AMFSearchResultsUtil.getDisplayHTML(user) %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>