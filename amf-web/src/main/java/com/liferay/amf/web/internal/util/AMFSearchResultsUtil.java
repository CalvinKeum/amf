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

package com.liferay.amf.web.internal.util;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Calvin Keum
 */
public class AMFSearchResultsUtil {

	public static String getDisplayHTML(User user) {
		StringBundler sb = new StringBundler(7);

		sb.append(getNameDisplayHTML(user));
		sb.append(StringPool.SPACE);
		sb.append(getScreenNameDisplayHTML(user));
		sb.append(StringPool.SPACE);
		sb.append(StringPool.DASH);
		sb.append(StringPool.SPACE);
		sb.append(user.getEmailAddress());

		return HtmlUtil.escape(sb.toString());
	}

	protected static String getNameDisplayHTML(User user) {
		StringBundler sb = new StringBundler(4);

		sb.append(user.getFirstName());
		sb.append(StringPool.SPACE);

		String lastNameInitial = user.getLastName();

		lastNameInitial = lastNameInitial.substring(0, 1);

		sb.append(StringUtil.upperCaseFirstLetter(lastNameInitial));

		sb.append(StringPool.PERIOD);

		return HtmlUtil.escape(sb.toString());
	}

	protected static String getScreenNameDisplayHTML(User user) {
		StringBundler sb = new StringBundler(3);

		sb.append(StringPool.OPEN_PARENTHESIS);
		sb.append(user.getScreenName());
		sb.append(StringPool.CLOSE_PARENTHESIS);

		return HtmlUtil.escape(sb.toString());
	}

}