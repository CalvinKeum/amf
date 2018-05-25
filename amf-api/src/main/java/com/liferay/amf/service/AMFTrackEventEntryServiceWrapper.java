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

package com.liferay.amf.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMFTrackEventEntryService}.
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntryService
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryServiceWrapper
	implements AMFTrackEventEntryService,
		ServiceWrapper<AMFTrackEventEntryService> {
	public AMFTrackEventEntryServiceWrapper(
		AMFTrackEventEntryService amfTrackEventEntryService) {
		_amfTrackEventEntryService = amfTrackEventEntryService;
	}

	@Override
	public int getAMFTrackEventEntryCount(
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfTrackEventEntryService.getAMFTrackEventEntryCount(serviceContext);
	}

	@Override
	public int getAMFTrackEventEntryCount(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type) throws com.liferay.portal.kernel.exception.PortalException {
		return _amfTrackEventEntryService.getAMFTrackEventEntryCount(serviceContext,
			type);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _amfTrackEventEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfTrackEventEntryService.getAMFTrackEventEntries(serviceContext,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _amfTrackEventEntryService.getAMFTrackEventEntries(serviceContext,
			type, start, end);
	}

	@Override
	public AMFTrackEventEntryService getWrappedService() {
		return _amfTrackEventEntryService;
	}

	@Override
	public void setWrappedService(
		AMFTrackEventEntryService amfTrackEventEntryService) {
		_amfTrackEventEntryService = amfTrackEventEntryService;
	}

	private AMFTrackEventEntryService _amfTrackEventEntryService;
}