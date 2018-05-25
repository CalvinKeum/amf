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

package com.liferay.amf.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.amf.constants.AMFTrackEventEntryConstants;
import java.text.SimpleDateFormat;

/**
 * @author Calvin Keum
 */
@ProviderType
public class AMFTrackEventEntryImpl extends AMFTrackEventEntryBaseImpl {

	public AMFTrackEventEntryImpl() {
	}

	@Override
	public String getCreateDateDisplayHTML() throws PortalException {
		String pattern = "yyyy-MM-dd HH:mm:ss";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(getCreateDate());

		return HtmlUtil.escape(date);
	}

	@Override
	public String getTypeLabelDisplayHTML() throws PortalException {
		String type = AMFTrackEventEntryConstants.getEventTypeLabel(getType());

		return HtmlUtil.escape(type);
	}

	@Override
	public String getUserNameIdDisplayHTML() throws PortalException {
		StringBundler sb = new StringBundler(5);

		sb.append(getUserName());
		sb.append(StringPool.SPACE);
		sb.append(StringPool.OPEN_PARENTHESIS);
		sb.append(getUserId());
		sb.append(StringPool.CLOSE_PARENTHESIS);

		return HtmlUtil.escape(sb.toString());
	}

}