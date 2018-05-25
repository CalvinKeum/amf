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

package com.liferay.amf.web.internal.display.context;

import com.liferay.portal.kernel.display.context.DisplayContext;

import java.text.Format;

/**
 * @author Calvin Keum
 */
public interface AMFMonitorDisplayContext extends DisplayContext {

	public Format getDateFormatDate();

	public int getPageDelta();

	public String getTabs1Names();

	public String getTabs1PortletURL();

	public boolean isShowAllTrackEventEntries();

	public boolean isShowLoginTrackEventEntries();

	public boolean isShowRegistrationTrackEventEntries();

	public boolean isTabs1Visible();

}