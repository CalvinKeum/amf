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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Calvin Keum
 */
@Component(
	property = {
		"javax.portlet.name=" + AMFPortletKeys.AMF_SEARCH_RESULTS,
		"mvc.command.name=/", "mvc.command.name=/amf_search/search_results"
	}
)
public class ViewSearchResultsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			List<User> results = new ArrayList<>();

			String search = ParamUtil.getString(renderRequest, "search");
			int delta = ParamUtil.getInteger(renderRequest, "delta", 5);

			PortletURL portletURL = renderResponse.createRenderURL();

			portletURL.setParameter(
				"mvcRenderCommandName", "/amf_search/search_results");
			portletURL.setParameter("search", search);

			SearchContainer searchContainer = new SearchContainer(
				renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM,
				delta, portletURL, null, "no-results-found");

			int total = 0;

			//
			System.out.println("AMFSearchResultsPortlet::render " + search);

			if (validateSearch(search)) {
				List<Long> userIds = getAddressUserIds(search);

				if (!ListUtil.isEmpty(userIds)) {
					System.out.println("userids not empty");
					DynamicQuery userDynamicQuery = getUsersDynamicQuery(
						userIds);

					results = _userLocalService.dynamicQuery(
						userDynamicQuery, searchContainer.getStart(),
						searchContainer.getEnd());

					userDynamicQuery = getUsersDynamicQuery(userIds);

					total = Math.toIntExact(
						_userLocalService.dynamicQueryCount(userDynamicQuery));
				}
			}
			else {
				search = StringPool.BLANK;
			}

			//
			System.out.println("total: " + total);

			searchContainer.setResults(results);
			searchContainer.setTotal(total);

			renderRequest.setAttribute("search", search);
			renderRequest.setAttribute("searchContainer", searchContainer);
			}
			catch (Exception e) {
			}

			return "/amf_search/search_results.jsp";
	}

	protected List<Long> getAddressUserIds(String search) {
		DynamicQuery addressDynamicQuery = _addressLocalService.dynamicQuery();

		addressDynamicQuery.setProjection(
			ProjectionFactoryUtil.property("userId"));

		Property primaryProperty = PropertyFactoryUtil.forName("primary");

		addressDynamicQuery.add(primaryProperty.eq(true));

		Property zipProperty = PropertyFactoryUtil.forName("zip");

		addressDynamicQuery.add(zipProperty.eq(search));

		return _addressLocalService.dynamicQuery(addressDynamicQuery);
	}

	protected DynamicQuery getUsersDynamicQuery(List<Long> userIds) {
		DynamicQuery userDynamicQuery = _userLocalService.dynamicQuery();

		Property userIdProperty = PropertyFactoryUtil.forName("userId");

		userDynamicQuery.add(userIdProperty.in(userIds));

		return userDynamicQuery;
	}

	protected boolean validateSearch(String zip) {
		if (Validator.isNull(zip)) {
			return false;
		}
		else if (!Validator.isDigit(zip)) {
			return false;
		}
		else if (zip.length() != _MAX_ZIP_LENGTH) {
			return false;
		}

		return true;
	}

	private static final int _MAX_ZIP_LENGTH = 5;

	@Reference
	private AddressLocalService _addressLocalService;

	@Reference
	private UserLocalService _userLocalService;

}