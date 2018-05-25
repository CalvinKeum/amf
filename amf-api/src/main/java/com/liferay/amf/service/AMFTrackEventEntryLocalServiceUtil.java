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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AMFTrackEventEntry. This utility wraps
 * {@link com.liferay.amf.service.impl.AMFTrackEventEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntryLocalService
 * @see com.liferay.amf.service.base.AMFTrackEventEntryLocalServiceBaseImpl
 * @see com.liferay.amf.service.impl.AMFTrackEventEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.amf.service.impl.AMFTrackEventEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the amf track event entry to the database. Also notifies the appropriate model listeners.
	*
	* @param amfTrackEventEntry the amf track event entry
	* @return the amf track event entry that was added
	*/
	public static com.liferay.amf.model.AMFTrackEventEntry addAMFTrackEventEntry(
		com.liferay.amf.model.AMFTrackEventEntry amfTrackEventEntry) {
		return getService().addAMFTrackEventEntry(amfTrackEventEntry);
	}

	public static com.liferay.amf.model.AMFTrackEventEntry addTrackEventEntry(
		long userId, int type, java.lang.String ipAddress)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addTrackEventEntry(userId, type, ipAddress);
	}

	/**
	* Creates a new amf track event entry with the primary key. Does not add the amf track event entry to the database.
	*
	* @param amfTrackEventEntryId the primary key for the new amf track event entry
	* @return the new amf track event entry
	*/
	public static com.liferay.amf.model.AMFTrackEventEntry createAMFTrackEventEntry(
		long amfTrackEventEntryId) {
		return getService().createAMFTrackEventEntry(amfTrackEventEntryId);
	}

	/**
	* Deletes the amf track event entry from the database. Also notifies the appropriate model listeners.
	*
	* @param amfTrackEventEntry the amf track event entry
	* @return the amf track event entry that was removed
	*/
	public static com.liferay.amf.model.AMFTrackEventEntry deleteAMFTrackEventEntry(
		com.liferay.amf.model.AMFTrackEventEntry amfTrackEventEntry) {
		return getService().deleteAMFTrackEventEntry(amfTrackEventEntry);
	}

	/**
	* Deletes the amf track event entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry that was removed
	* @throws PortalException if a amf track event entry with the primary key could not be found
	*/
	public static com.liferay.amf.model.AMFTrackEventEntry deleteAMFTrackEventEntry(
		long amfTrackEventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAMFTrackEventEntry(amfTrackEventEntryId);
	}

	public static com.liferay.amf.model.AMFTrackEventEntry fetchAMFTrackEventEntry(
		long amfTrackEventEntryId) {
		return getService().fetchAMFTrackEventEntry(amfTrackEventEntryId);
	}

	/**
	* Returns the amf track event entry with the primary key.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry
	* @throws PortalException if a amf track event entry with the primary key could not be found
	*/
	public static com.liferay.amf.model.AMFTrackEventEntry getAMFTrackEventEntry(
		long amfTrackEventEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAMFTrackEventEntry(amfTrackEventEntryId);
	}

	/**
	* Updates the amf track event entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param amfTrackEventEntry the amf track event entry
	* @return the amf track event entry that was updated
	*/
	public static com.liferay.amf.model.AMFTrackEventEntry updateAMFTrackEventEntry(
		com.liferay.amf.model.AMFTrackEventEntry amfTrackEventEntry) {
		return getService().updateAMFTrackEventEntry(amfTrackEventEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int count(int type)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().count(type);
	}

	public static int count(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().count(userId);
	}

	public static int count(long userId, int type)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().count(userId, type);
	}

	/**
	* Returns the number of amf track event entries.
	*
	* @return the number of amf track event entries
	*/
	public static int getAMFTrackEventEntriesCount() {
		return getService().getAMFTrackEventEntriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.amf.model.impl.AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.amf.model.impl.AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the amf track event entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.amf.model.impl.AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @return the range of amf track event entries
	*/
	public static java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		int start, int end) {
		return getService().getAMFTrackEventEntries(start, end);
	}

	public static java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAMFTrackEventEntries(type, start, end);
	}

	public static java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAMFTrackEventEntries(userId, start, end);
	}

	public static java.util.List<com.liferay.amf.model.AMFTrackEventEntry> getAMFTrackEventEntries(
		long userId, int type, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAMFTrackEventEntries(userId, type, start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AMFTrackEventEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFTrackEventEntryLocalService, AMFTrackEventEntryLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AMFTrackEventEntryLocalService.class);
}