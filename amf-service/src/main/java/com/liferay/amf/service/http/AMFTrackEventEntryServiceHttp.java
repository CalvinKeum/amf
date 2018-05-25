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

package com.liferay.amf.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.service.AMFTrackEventEntryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link AMFTrackEventEntryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntryServiceSoap
 * @see HttpPrincipal
 * @see AMFTrackEventEntryServiceUtil
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryServiceHttp {
	public static java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AMFTrackEventEntryServiceUtil.class,
					"getAMFTrackEventEntries",
					_getAMFTrackEventEntriesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.amf.model.AMFTrackEventEntry>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AMFTrackEventEntryServiceUtil.class,
					"getAMFTrackEventEntries",
					_getAMFTrackEventEntriesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext, type, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.amf.model.AMFTrackEventEntry>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAMFTrackEventEntryCount(HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AMFTrackEventEntryServiceUtil.class,
					"getAMFTrackEventEntryCount",
					_getAMFTrackEventEntryCountParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAMFTrackEventEntryCount(HttpPrincipal httpPrincipal,
		com.liferay.portal.kernel.service.ServiceContext serviceContext,
		int type) throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AMFTrackEventEntryServiceUtil.class,
					"getAMFTrackEventEntryCount",
					_getAMFTrackEventEntryCountParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					serviceContext, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AMFTrackEventEntryServiceHttp.class);
	private static final Class<?>[] _getAMFTrackEventEntriesParameterTypes0 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, int.class,
			int.class
		};
	private static final Class<?>[] _getAMFTrackEventEntriesParameterTypes1 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, int.class,
			int.class, int.class
		};
	private static final Class<?>[] _getAMFTrackEventEntryCountParameterTypes2 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAMFTrackEventEntryCountParameterTypes3 = new Class[] {
			com.liferay.portal.kernel.service.ServiceContext.class, int.class
		};
}