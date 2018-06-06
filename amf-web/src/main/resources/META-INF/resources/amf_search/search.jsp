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

<c:choose>
	<c:when test="${hasViewPermission}">
		<portlet:actionURL name="/amf_search/search" var="searchActionURL" windowState="normal">
			<portlet:param name="mvcRenderCommandName" value="/amf_search/search" />
		</portlet:actionURL>

		<liferay-ui:error key="zipCodeInvalid">
			<liferay-ui:message arguments="${maxDigitsZip}" key="the-zip-code-must-be-x-digits-long" translateArguments="<%= false %>" />
		</liferay-ui:error>

		<aui:form action="<%= searchActionURL %>" method="post" name="fm">
			<aui:input label="enter-us-zip" name="searchZip" type="text">
				<aui:validator errorMessage="The zip code must be ${maxDigitsZip} digits long" name="custom">
					function(val, fieldNode, ruleValue) {
						return ((val.length != ${maxDigitsZip}) ? false : true);
					}
				</aui:validator>

				<aui:validator name="digits" />
				<aui:validator name="required" />
			</aui:input>

			<aui:button type="submit" value="search" />
		</aui:form>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key='<%= LanguageUtil.format(request, "you-do-not-have-permission-to-access-the-requested-resource", false) %>' />
	</c:otherwise>
</c:choose>