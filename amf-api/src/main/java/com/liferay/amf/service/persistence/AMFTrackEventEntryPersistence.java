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

import com.liferay.amf.exception.NoSuchTrackEventEntryException;
import com.liferay.amf.model.AMFTrackEventEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the amf track event entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Calvin Keum
 * @see com.liferay.amf.service.persistence.impl.AMFTrackEventEntryPersistenceImpl
 * @see AMFTrackEventEntryUtil
 * @generated
 */
@ProviderType
public interface AMFTrackEventEntryPersistence extends BasePersistence<AMFTrackEventEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFTrackEventEntryUtil} to access the amf track event entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the amf track event entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching amf track event entries
	*/
	public java.util.List<AMFTrackEventEntry> findByUserId(long userId);

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
	public java.util.List<AMFTrackEventEntry> findByUserId(long userId,
		int start, int end);

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
	public java.util.List<AMFTrackEventEntry> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

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
	public java.util.List<AMFTrackEventEntry> findByUserId(long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

	/**
	* Returns the amf track event entries before and after the current amf track event entry in the ordered set where userId = &#63;.
	*
	* @param amfTrackEventEntryId the primary key of the current amf track event entry
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public AMFTrackEventEntry[] findByUserId_PrevAndNext(
		long amfTrackEventEntryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Removes all the amf track event entries where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of amf track event entries where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching amf track event entries
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the amf track event entries where type = &#63;.
	*
	* @param type the type
	* @return the matching amf track event entries
	*/
	public java.util.List<AMFTrackEventEntry> findByType(int type);

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
	public java.util.List<AMFTrackEventEntry> findByType(int type, int start,
		int end);

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
	public java.util.List<AMFTrackEventEntry> findByType(int type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

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
	public java.util.List<AMFTrackEventEntry> findByType(int type, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry findByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the first amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry fetchByType_First(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

	/**
	* Returns the last amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry findByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the last amf track event entry in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry fetchByType_Last(int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

	/**
	* Returns the amf track event entries before and after the current amf track event entry in the ordered set where type = &#63;.
	*
	* @param amfTrackEventEntryId the primary key of the current amf track event entry
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public AMFTrackEventEntry[] findByType_PrevAndNext(
		long amfTrackEventEntryId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Removes all the amf track event entries where type = &#63; from the database.
	*
	* @param type the type
	*/
	public void removeByType(int type);

	/**
	* Returns the number of amf track event entries where type = &#63;.
	*
	* @param type the type
	* @return the number of matching amf track event entries
	*/
	public int countByType(int type);

	/**
	* Returns all the amf track event entries where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @return the matching amf track event entries
	*/
	public java.util.List<AMFTrackEventEntry> findByU_T(long userId, int type);

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
	public java.util.List<AMFTrackEventEntry> findByU_T(long userId, int type,
		int start, int end);

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
	public java.util.List<AMFTrackEventEntry> findByU_T(long userId, int type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

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
	public java.util.List<AMFTrackEventEntry> findByU_T(long userId, int type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry findByU_T_First(long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the first amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry fetchByU_T_First(long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry
	* @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry findByU_T_Last(long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the last amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	*/
	public AMFTrackEventEntry fetchByU_T_Last(long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

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
	public AMFTrackEventEntry[] findByU_T_PrevAndNext(
		long amfTrackEventEntryId, long userId, int type,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException;

	/**
	* Removes all the amf track event entries where userId = &#63; and type = &#63; from the database.
	*
	* @param userId the user ID
	* @param type the type
	*/
	public void removeByU_T(long userId, int type);

	/**
	* Returns the number of amf track event entries where userId = &#63; and type = &#63;.
	*
	* @param userId the user ID
	* @param type the type
	* @return the number of matching amf track event entries
	*/
	public int countByU_T(long userId, int type);

	/**
	* Caches the amf track event entry in the entity cache if it is enabled.
	*
	* @param amfTrackEventEntry the amf track event entry
	*/
	public void cacheResult(AMFTrackEventEntry amfTrackEventEntry);

	/**
	* Caches the amf track event entries in the entity cache if it is enabled.
	*
	* @param amfTrackEventEntries the amf track event entries
	*/
	public void cacheResult(
		java.util.List<AMFTrackEventEntry> amfTrackEventEntries);

	/**
	* Creates a new amf track event entry with the primary key. Does not add the amf track event entry to the database.
	*
	* @param amfTrackEventEntryId the primary key for the new amf track event entry
	* @return the new amf track event entry
	*/
	public AMFTrackEventEntry create(long amfTrackEventEntryId);

	/**
	* Removes the amf track event entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry that was removed
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public AMFTrackEventEntry remove(long amfTrackEventEntryId)
		throws NoSuchTrackEventEntryException;

	public AMFTrackEventEntry updateImpl(AMFTrackEventEntry amfTrackEventEntry);

	/**
	* Returns the amf track event entry with the primary key or throws a {@link NoSuchTrackEventEntryException} if it could not be found.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry
	* @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	*/
	public AMFTrackEventEntry findByPrimaryKey(long amfTrackEventEntryId)
		throws NoSuchTrackEventEntryException;

	/**
	* Returns the amf track event entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param amfTrackEventEntryId the primary key of the amf track event entry
	* @return the amf track event entry, or <code>null</code> if a amf track event entry with the primary key could not be found
	*/
	public AMFTrackEventEntry fetchByPrimaryKey(long amfTrackEventEntryId);

	@Override
	public java.util.Map<java.io.Serializable, AMFTrackEventEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the amf track event entries.
	*
	* @return the amf track event entries
	*/
	public java.util.List<AMFTrackEventEntry> findAll();

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
	public java.util.List<AMFTrackEventEntry> findAll(int start, int end);

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
	public java.util.List<AMFTrackEventEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator);

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
	public java.util.List<AMFTrackEventEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the amf track event entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of amf track event entries.
	*
	* @return the number of amf track event entries
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}