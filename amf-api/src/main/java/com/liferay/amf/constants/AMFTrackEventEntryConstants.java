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

package com.liferay.amf.constants;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Calvin Keum
 */
public class AMFTrackEventEntryConstants {

	public static final String LABEL_LOGIN = "login";

	public static final String _LABEL_REGISTRATION = "registration ";

	public static final String EMPTY_IP_ADDRESS = "0.0.0.0";

	public static final int TYPE_LOGIN = 1;

	public static final int TYPE_REGISTRATION = 2;

	public static String getEventTypeLabel(int type) {
		if (type == TYPE_LOGIN) {
			return LABEL_LOGIN;
		}
		else if (type == TYPE_REGISTRATION) {
			return _LABEL_REGISTRATION;
		}

		return StringPool.BLANK;
	}

}