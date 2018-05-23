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

package com.liferay.amf.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.model.AMFTrackEventEntry;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the amf track event entry service. This utility wraps {@link com.liferay.amf.service.persistence.impl.AMFTrackEventEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntryPersistence
 * @see com.liferay.amf.service.persistence.impl.AMFTrackEventEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AMFTrackEventEntry amfTrackEventEntry) {
		getPersistence().clearCache(amfTrackEventEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFTrackEventEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFTrackEventEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFTrackEventEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFTrackEventEntry update(
		AMFTrackEventEntry amfTrackEventEntry) {
		return getPersistence().update(amfTrackEventEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFTrackEventEntry update(
		AMFTrackEventEntry amfTrackEventEntry, ServiceContext serviceContext) {
		return getPersistence().update(amfTrackEventEntry, serviceContext);
	}

	/**
	* Returns all the amf track event entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the amf track event entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @return the range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByUserId(long userId, int start,
		int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the amf track event entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf track event entries where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry findByUserId_First(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry fetchByUserId_First(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry findByUserId_Last(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry fetchByUserId_Last(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the amf track event entries before and after the current amf track event entry in the ordered set where userId = &#63;.
	*
	* @param amfTrackEventEntryId the primary key of the current amf track event entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public static AMFTrackEventEntry[] findByUserId_PrevAndNext(
		long amfTrackEventEntryId, long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence()
				   .findByUserId_PrevAndNext(amfTrackEventEntryId, userId,
			orderByComparator);
	}

	/**
	* Removes all the amf track event entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of amf track event entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching amf track event entries
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the amf track event entries where type = &#63;.
	*
	* @param type the type
	* @return the matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByType(int type) {
		return getPersistence().findByType(type);
	}

	/**
	* Returns a range of all the amf track event entries where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @return the range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByType(int type, int start,
		int end) {
		return getPersistence().findByType(type, start, end);
	}

	/**
	* Returns an ordered range of all the amf track event entries where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByType(int type, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf track event entries where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByType(int type, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByType(type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry findByType_First(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry fetchByType_First(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry findByType_Last(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry fetchByType_Last(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

	/**
	* Returns the amf track event entries before and after the current amf track event entry in the ordered set where type = &#63;.
	*
	* @param amfTrackEventEntryId the primary key of the current amf track event entry
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public static AMFTrackEventEntry[] findByType_PrevAndNext(
		long amfTrackEventEntryId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence()
				   .findByType_PrevAndNext(amfTrackEventEntryId, type,
			orderByComparator);
	}

	/**
	* Removes all the amf track event entries where type = &#63; from the database.
	*
	* @param type the type
	*/
	public static void removeByType(int type) {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of amf track event entries where type = &#63;.
	*
	* @param type the type
	* @return the number of matching amf track event entries
	*/
	public static int countByType(int type) {
		return getPersistence().countByType(type);
	}

	/**
	* Returns all the amf track event entries where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @return the matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByU_T(long userId, int type) {
		return getPersistence().findByU_T(userId, type);
	}

	/**
	* Returns a range of all the amf track event entries where userId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param type the type
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @return the range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByU_T(long userId, int type,
		int start, int end) {
		return getPersistence().findByU_T(userId, type, start, end);
	}

	/**
	* Returns an ordered range of all the amf track event entries where userId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param type the type
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByU_T(long userId, int type,
		int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence()
				   .findByU_T(userId, type, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf track event entries where userId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param type the type
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching amf track event entries
	*/
	public static List<AMFTrackEventEntry> findByU_T(long userId, int type,
		int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByU_T(userId, type, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry findByU_T_First(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByU_T_First(userId, type, orderByComparator);
	}

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry fetchByU_T_First(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().fetchByU_T_First(userId, type, orderByComparator);
	}

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry findByU_T_Last(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByU_T_Last(userId, type, orderByComparator);
	}

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public static AMFTrackEventEntry fetchByU_T_Last(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().fetchByU_T_Last(userId, type, orderByComparator);
	}

	/**
	* Returns the amf track event entries before and after the current amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param amfTrackEventEntryId the primary key of the current amf track event entry
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public static AMFTrackEventEntry[] findByU_T_PrevAndNext(
		long amfTrackEventEntryId, long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence()
				   .findByU_T_PrevAndNext(amfTrackEventEntryId, userId, type,
			orderByComparator);
	}

	/**
	* Removes all the amf track event entries where userId = &#63; and type = &#63; from the database.
	*
	* @param userId the user ID
	* @param type the type
	*/
	public static void removeByU_T(long userId, int type) {
		getPersistence().removeByU_T(userId, type);
	}

	/**
	* Returns the number of amf track event entries where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @return the number of matching amf track event entries
	*/
	public static int countByU_T(long userId, int type) {
		return getPersistence().countByU_T(userId, type);
	}

	/**
	* Caches the amf track event entry in the entity cache if it is enabled.
	*
	* @param amfTrackEventEntry the amf track event entry
	*/
	public static void cacheResult(AMFTrackEventEntry amfTrackEventEntry) {
		getPersistence().cacheResult(amfTrackEventEntry);
	}

	/**
	* Caches the amf track event entries in the entity cache if it is enabled.
	*
	* @param amfTrackEventEntries the amf track event entries
	*/
	public static void cacheResult(
		List<AMFTrackEventEntry> amfTrackEventEntries) {
		getPersistence().cacheResult(amfTrackEventEntries);
	}

	/**
	* Creates a new amf track event entry with the primary key. Does not add the amf track event entry to the database.
	*
	* @param amfTrackEventEntryId the primary key for the new amf track event entry
	* @return the new amf track event entry
	*/
	public static AMFTrackEventEntry create(long amfTrackEventEntryId) {
		return getPersistence().create(amfTrackEventEntryId);
	}

	/**
	* Removes the amf track event entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry that was removed
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public static AMFTrackEventEntry remove(long amfTrackEventEntryId)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().remove(amfTrackEventEntryId);
	}

	public static AMFTrackEventEntry updateImpl(
		AMFTrackEventEntry amfTrackEventEntry) {
		return getPersistence().updateImpl(amfTrackEventEntry);
	}

	/**
	* Returns the amf track event entry with the primary key or throws a {@link NoSuchTrackEventEntryException} if it could not be found.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public static AMFTrackEventEntry findByPrimaryKey(long amfTrackEventEntryId)
		throws com.liferay.amf.exception.NoSuchTrackEventEntryException {
		return getPersistence().findByPrimaryKey(amfTrackEventEntryId);
	}

	/**
	* Returns the amf track event entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry, or <code>null</code> if a amf track event entry with the primary key could not be found
	*/
	public static AMFTrackEventEntry fetchByPrimaryKey(
		long amfTrackEventEntryId) {
		return getPersistence().fetchByPrimaryKey(amfTrackEventEntryId);
	}

	public static java.util.Map<java.io.Serializable, AMFTrackEventEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the amf track event entries.
	*
	* @return the amf track event entries
	*/
	public static List<AMFTrackEventEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the amf track event entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @return the range of amf track event entries
	*/
	public static List<AMFTrackEventEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the amf track event entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of amf track event entries
	*/
	public static List<AMFTrackEventEntry> findAll(int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the amf track event entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AMFTrackEventEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of amf track event entries
	* @param end the upper bound of the range of amf track event entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of amf track event entries
	*/
	public static List<AMFTrackEventEntry> findAll(int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the amf track event entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of amf track event entries.
	*
	* @return the number of amf track event entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AMFTrackEventEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFTrackEventEntryPersistence, AMFTrackEventEntryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AMFTrackEventEntryPersistence.class);
}