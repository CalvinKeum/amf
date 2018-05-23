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

package com.liferay.amf.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.exception.NoSuchTrackEventEntryException;
import com.liferay.amf.model.AMFTrackEventEntry;
import com.liferay.amf.model.impl.AMFTrackEventEntryImpl;
import com.liferay.amf.model.impl.AMFTrackEventEntryModelImpl;
import com.liferay.amf.service.persistence.AMFTrackEventEntryPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the amf track event entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntryPersistence
 * @see com.liferay.amf.service.persistence.AMFTrackEventEntryUtil
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryPersistenceImpl extends BasePersistenceImpl<AMFTrackEventEntry>
	implements AMFTrackEventEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AMFTrackEventEntryUtil} to access the amf track event entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AMFTrackEventEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			AMFTrackEventEntryModelImpl.USERID_COLUMN_BITMASK |
			AMFTrackEventEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the amf track event entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching amf track event entries
	 */
	@Override
	public List<AMFTrackEventEntry> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFTrackEventEntry> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<AMFTrackEventEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<AMFTrackEventEntry> findByUserId(long userId, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<AMFTrackEventEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AMFTrackEventEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFTrackEventEntry amfTrackEventEntry : list) {
					if ((userId != amfTrackEventEntry.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf track event entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf track event entry
	 * @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry findByUserId_First(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByUserId_First(userId,
				orderByComparator);

		if (amfTrackEventEntry != null) {
			return amfTrackEventEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventEntryException(msg.toString());
	}

	/**
	 * Returns the first amf track event entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByUserId_First(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		List<AMFTrackEventEntry> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf track event entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf track event entry
	 * @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry findByUserId_Last(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByUserId_Last(userId,
				orderByComparator);

		if (amfTrackEventEntry != null) {
			return amfTrackEventEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventEntryException(msg.toString());
	}

	/**
	 * Returns the last amf track event entry in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByUserId_Last(long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<AMFTrackEventEntry> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFTrackEventEntry[] findByUserId_PrevAndNext(
		long amfTrackEventEntryId, long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = findByPrimaryKey(amfTrackEventEntryId);

		Session session = null;

		try {
			session = openSession();

			AMFTrackEventEntry[] array = new AMFTrackEventEntryImpl[3];

			array[0] = getByUserId_PrevAndNext(session, amfTrackEventEntry,
					userId, orderByComparator, true);

			array[1] = amfTrackEventEntry;

			array[2] = getByUserId_PrevAndNext(session, amfTrackEventEntry,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFTrackEventEntry getByUserId_PrevAndNext(Session session,
		AMFTrackEventEntry amfTrackEventEntry, long userId,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfTrackEventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AMFTrackEventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf track event entries where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (AMFTrackEventEntry amfTrackEventEntry : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfTrackEventEntry);
		}
	}

	/**
	 * Returns the number of amf track event entries where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching amf track event entries
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFTRACKEVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "amfTrackEventEntry.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { Integer.class.getName() },
			AMFTrackEventEntryModelImpl.TYPE_COLUMN_BITMASK |
			AMFTrackEventEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the amf track event entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching amf track event entries
	 */
	@Override
	public List<AMFTrackEventEntry> findByType(int type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFTrackEventEntry> findByType(int type, int start, int end) {
		return findByType(type, start, end, null);
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
	@Override
	public List<AMFTrackEventEntry> findByType(int type, int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return findByType(type, start, end, orderByComparator, true);
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
	@Override
	public List<AMFTrackEventEntry> findByType(int type, int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<AMFTrackEventEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AMFTrackEventEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFTrackEventEntry amfTrackEventEntry : list) {
					if ((type != amfTrackEventEntry.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				if (!pagination) {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first amf track event entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf track event entry
	 * @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry findByType_First(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByType_First(type,
				orderByComparator);

		if (amfTrackEventEntry != null) {
			return amfTrackEventEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventEntryException(msg.toString());
	}

	/**
	 * Returns the first amf track event entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByType_First(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		List<AMFTrackEventEntry> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf track event entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf track event entry
	 * @throws NoSuchTrackEventEntryException if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry findByType_Last(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByType_Last(type,
				orderByComparator);

		if (amfTrackEventEntry != null) {
			return amfTrackEventEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventEntryException(msg.toString());
	}

	/**
	 * Returns the last amf track event entry in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByType_Last(int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<AMFTrackEventEntry> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFTrackEventEntry[] findByType_PrevAndNext(
		long amfTrackEventEntryId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = findByPrimaryKey(amfTrackEventEntryId);

		Session session = null;

		try {
			session = openSession();

			AMFTrackEventEntry[] array = new AMFTrackEventEntryImpl[3];

			array[0] = getByType_PrevAndNext(session, amfTrackEventEntry, type,
					orderByComparator, true);

			array[1] = amfTrackEventEntry;

			array[2] = getByType_PrevAndNext(session, amfTrackEventEntry, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFTrackEventEntry getByType_PrevAndNext(Session session,
		AMFTrackEventEntry amfTrackEventEntry, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_TYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfTrackEventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AMFTrackEventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf track event entries where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(int type) {
		for (AMFTrackEventEntry amfTrackEventEntry : findByType(type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfTrackEventEntry);
		}
	}

	/**
	 * Returns the number of amf track event entries where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching amf track event entries
	 */
	@Override
	public int countByType(int type) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_AMFTRACKEVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "amfTrackEventEntry.type = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_U_T = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_T",
			new String[] { Long.class.getName(), Integer.class.getName() },
			AMFTrackEventEntryModelImpl.USERID_COLUMN_BITMASK |
			AMFTrackEventEntryModelImpl.TYPE_COLUMN_BITMASK |
			AMFTrackEventEntryModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_U_T = new FinderPath(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_T",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the amf track event entries where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the matching amf track event entries
	 */
	@Override
	public List<AMFTrackEventEntry> findByU_T(long userId, int type) {
		return findByU_T(userId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<AMFTrackEventEntry> findByU_T(long userId, int type, int start,
		int end) {
		return findByU_T(userId, type, start, end, null);
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
	@Override
	public List<AMFTrackEventEntry> findByU_T(long userId, int type, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return findByU_T(userId, type, start, end, orderByComparator, true);
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
	@Override
	public List<AMFTrackEventEntry> findByU_T(long userId, int type, int start,
		int end, OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T;
			finderArgs = new Object[] { userId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_U_T;
			finderArgs = new Object[] {
					userId, type,
					
					start, end, orderByComparator
				};
		}

		List<AMFTrackEventEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AMFTrackEventEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFTrackEventEntry amfTrackEventEntry : list) {
					if ((userId != amfTrackEventEntry.getUserId()) ||
							(type != amfTrackEventEntry.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_T_USERID_2);

			query.append(_FINDER_COLUMN_U_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(type);

				if (!pagination) {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AMFTrackEventEntry findByU_T_First(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByU_T_First(userId, type,
				orderByComparator);

		if (amfTrackEventEntry != null) {
			return amfTrackEventEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventEntryException(msg.toString());
	}

	/**
	 * Returns the first amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByU_T_First(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		List<AMFTrackEventEntry> list = findByU_T(userId, type, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFTrackEventEntry findByU_T_Last(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByU_T_Last(userId, type,
				orderByComparator);

		if (amfTrackEventEntry != null) {
			return amfTrackEventEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTrackEventEntryException(msg.toString());
	}

	/**
	 * Returns the last amf track event entry in the ordered set where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf track event entry, or <code>null</code> if a matching amf track event entry could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByU_T_Last(long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		int count = countByU_T(userId, type);

		if (count == 0) {
			return null;
		}

		List<AMFTrackEventEntry> list = findByU_T(userId, type, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFTrackEventEntry[] findByU_T_PrevAndNext(
		long amfTrackEventEntryId, long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = findByPrimaryKey(amfTrackEventEntryId);

		Session session = null;

		try {
			session = openSession();

			AMFTrackEventEntry[] array = new AMFTrackEventEntryImpl[3];

			array[0] = getByU_T_PrevAndNext(session, amfTrackEventEntry,
					userId, type, orderByComparator, true);

			array[1] = amfTrackEventEntry;

			array[2] = getByU_T_PrevAndNext(session, amfTrackEventEntry,
					userId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFTrackEventEntry getByU_T_PrevAndNext(Session session,
		AMFTrackEventEntry amfTrackEventEntry, long userId, int type,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_T_USERID_2);

		query.append(_FINDER_COLUMN_U_T_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(type);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(amfTrackEventEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AMFTrackEventEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf track event entries where userId = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param type the type
	 */
	@Override
	public void removeByU_T(long userId, int type) {
		for (AMFTrackEventEntry amfTrackEventEntry : findByU_T(userId, type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(amfTrackEventEntry);
		}
	}

	/**
	 * Returns the number of amf track event entries where userId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param type the type
	 * @return the number of matching amf track event entries
	 */
	@Override
	public int countByU_T(long userId, int type) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_U_T;

		Object[] finderArgs = new Object[] { userId, type };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_AMFTRACKEVENTENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_T_USERID_2);

			query.append(_FINDER_COLUMN_U_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_T_USERID_2 = "amfTrackEventEntry.userId = ? AND ";
	private static final String _FINDER_COLUMN_U_T_TYPE_2 = "amfTrackEventEntry.type = ?";

	public AMFTrackEventEntryPersistenceImpl() {
		setModelClass(AMFTrackEventEntry.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the amf track event entry in the entity cache if it is enabled.
	 *
	 * @param amfTrackEventEntry the amf track event entry
	 */
	@Override
	public void cacheResult(AMFTrackEventEntry amfTrackEventEntry) {
		entityCache.putResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class, amfTrackEventEntry.getPrimaryKey(),
			amfTrackEventEntry);

		amfTrackEventEntry.resetOriginalValues();
	}

	/**
	 * Caches the amf track event entries in the entity cache if it is enabled.
	 *
	 * @param amfTrackEventEntries the amf track event entries
	 */
	@Override
	public void cacheResult(List<AMFTrackEventEntry> amfTrackEventEntries) {
		for (AMFTrackEventEntry amfTrackEventEntry : amfTrackEventEntries) {
			if (entityCache.getResult(
						AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
						AMFTrackEventEntryImpl.class,
						amfTrackEventEntry.getPrimaryKey()) == null) {
				cacheResult(amfTrackEventEntry);
			}
			else {
				amfTrackEventEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all amf track event entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMFTrackEventEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf track event entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFTrackEventEntry amfTrackEventEntry) {
		entityCache.removeResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class, amfTrackEventEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AMFTrackEventEntry> amfTrackEventEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AMFTrackEventEntry amfTrackEventEntry : amfTrackEventEntries) {
			entityCache.removeResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
				AMFTrackEventEntryImpl.class, amfTrackEventEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new amf track event entry with the primary key. Does not add the amf track event entry to the database.
	 *
	 * @param amfTrackEventEntryId the primary key for the new amf track event entry
	 * @return the new amf track event entry
	 */
	@Override
	public AMFTrackEventEntry create(long amfTrackEventEntryId) {
		AMFTrackEventEntry amfTrackEventEntry = new AMFTrackEventEntryImpl();

		amfTrackEventEntry.setNew(true);
		amfTrackEventEntry.setPrimaryKey(amfTrackEventEntryId);

		return amfTrackEventEntry;
	}

	/**
	 * Removes the amf track event entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfTrackEventEntryId the primary key of the amf track event entry
	 * @return the amf track event entry that was removed
	 * @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry remove(long amfTrackEventEntryId)
		throws NoSuchTrackEventEntryException {
		return remove((Serializable)amfTrackEventEntryId);
	}

	/**
	 * Removes the amf track event entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf track event entry
	 * @return the amf track event entry that was removed
	 * @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry remove(Serializable primaryKey)
		throws NoSuchTrackEventEntryException {
		Session session = null;

		try {
			session = openSession();

			AMFTrackEventEntry amfTrackEventEntry = (AMFTrackEventEntry)session.get(AMFTrackEventEntryImpl.class,
					primaryKey);

			if (amfTrackEventEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTrackEventEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(amfTrackEventEntry);
		}
		catch (NoSuchTrackEventEntryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AMFTrackEventEntry removeImpl(
		AMFTrackEventEntry amfTrackEventEntry) {
		amfTrackEventEntry = toUnwrappedModel(amfTrackEventEntry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfTrackEventEntry)) {
				amfTrackEventEntry = (AMFTrackEventEntry)session.get(AMFTrackEventEntryImpl.class,
						amfTrackEventEntry.getPrimaryKeyObj());
			}

			if (amfTrackEventEntry != null) {
				session.delete(amfTrackEventEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (amfTrackEventEntry != null) {
			clearCache(amfTrackEventEntry);
		}

		return amfTrackEventEntry;
	}

	@Override
	public AMFTrackEventEntry updateImpl(AMFTrackEventEntry amfTrackEventEntry) {
		amfTrackEventEntry = toUnwrappedModel(amfTrackEventEntry);

		boolean isNew = amfTrackEventEntry.isNew();

		AMFTrackEventEntryModelImpl amfTrackEventEntryModelImpl = (AMFTrackEventEntryModelImpl)amfTrackEventEntry;

		Session session = null;

		try {
			session = openSession();

			if (amfTrackEventEntry.isNew()) {
				session.save(amfTrackEventEntry);

				amfTrackEventEntry.setNew(false);
			}
			else {
				amfTrackEventEntry = (AMFTrackEventEntry)session.merge(amfTrackEventEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AMFTrackEventEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { amfTrackEventEntryModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
				args);

			args = new Object[] { amfTrackEventEntryModelImpl.getType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
				args);

			args = new Object[] {
					amfTrackEventEntryModelImpl.getUserId(),
					amfTrackEventEntryModelImpl.getType()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_U_T, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((amfTrackEventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfTrackEventEntryModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { amfTrackEventEntryModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((amfTrackEventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfTrackEventEntryModelImpl.getOriginalType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { amfTrackEventEntryModelImpl.getType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}

			if ((amfTrackEventEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						amfTrackEventEntryModelImpl.getOriginalUserId(),
						amfTrackEventEntryModelImpl.getOriginalType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_T, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T,
					args);

				args = new Object[] {
						amfTrackEventEntryModelImpl.getUserId(),
						amfTrackEventEntryModelImpl.getType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_U_T, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_U_T,
					args);
			}
		}

		entityCache.putResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
			AMFTrackEventEntryImpl.class, amfTrackEventEntry.getPrimaryKey(),
			amfTrackEventEntry, false);

		amfTrackEventEntry.resetOriginalValues();

		return amfTrackEventEntry;
	}

	protected AMFTrackEventEntry toUnwrappedModel(
		AMFTrackEventEntry amfTrackEventEntry) {
		if (amfTrackEventEntry instanceof AMFTrackEventEntryImpl) {
			return amfTrackEventEntry;
		}

		AMFTrackEventEntryImpl amfTrackEventEntryImpl = new AMFTrackEventEntryImpl();

		amfTrackEventEntryImpl.setNew(amfTrackEventEntry.isNew());
		amfTrackEventEntryImpl.setPrimaryKey(amfTrackEventEntry.getPrimaryKey());

		amfTrackEventEntryImpl.setAmfTrackEventEntryId(amfTrackEventEntry.getAmfTrackEventEntryId());
		amfTrackEventEntryImpl.setCreateDate(amfTrackEventEntry.getCreateDate());
		amfTrackEventEntryImpl.setUserId(amfTrackEventEntry.getUserId());
		amfTrackEventEntryImpl.setType(amfTrackEventEntry.getType());
		amfTrackEventEntryImpl.setIpAddress(amfTrackEventEntry.getIpAddress());

		return amfTrackEventEntryImpl;
	}

	/**
	 * Returns the amf track event entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf track event entry
	 * @return the amf track event entry
	 * @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTrackEventEntryException {
		AMFTrackEventEntry amfTrackEventEntry = fetchByPrimaryKey(primaryKey);

		if (amfTrackEventEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTrackEventEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return amfTrackEventEntry;
	}

	/**
	 * Returns the amf track event entry with the primary key or throws a {@link NoSuchTrackEventEntryException} if it could not be found.
	 *
	 * @param amfTrackEventEntryId the primary key of the amf track event entry
	 * @return the amf track event entry
	 * @throws NoSuchTrackEventEntryException if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry findByPrimaryKey(long amfTrackEventEntryId)
		throws NoSuchTrackEventEntryException {
		return findByPrimaryKey((Serializable)amfTrackEventEntryId);
	}

	/**
	 * Returns the amf track event entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf track event entry
	 * @return the amf track event entry, or <code>null</code> if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
				AMFTrackEventEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AMFTrackEventEntry amfTrackEventEntry = (AMFTrackEventEntry)serializable;

		if (amfTrackEventEntry == null) {
			Session session = null;

			try {
				session = openSession();

				amfTrackEventEntry = (AMFTrackEventEntry)session.get(AMFTrackEventEntryImpl.class,
						primaryKey);

				if (amfTrackEventEntry != null) {
					cacheResult(amfTrackEventEntry);
				}
				else {
					entityCache.putResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
						AMFTrackEventEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
					AMFTrackEventEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return amfTrackEventEntry;
	}

	/**
	 * Returns the amf track event entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfTrackEventEntryId the primary key of the amf track event entry
	 * @return the amf track event entry, or <code>null</code> if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry fetchByPrimaryKey(long amfTrackEventEntryId) {
		return fetchByPrimaryKey((Serializable)amfTrackEventEntryId);
	}

	@Override
	public Map<Serializable, AMFTrackEventEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AMFTrackEventEntry> map = new HashMap<Serializable, AMFTrackEventEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AMFTrackEventEntry amfTrackEventEntry = fetchByPrimaryKey(primaryKey);

			if (amfTrackEventEntry != null) {
				map.put(primaryKey, amfTrackEventEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
					AMFTrackEventEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AMFTrackEventEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_AMFTRACKEVENTENTRY_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AMFTrackEventEntry amfTrackEventEntry : (List<AMFTrackEventEntry>)q.list()) {
				map.put(amfTrackEventEntry.getPrimaryKeyObj(),
					amfTrackEventEntry);

				cacheResult(amfTrackEventEntry);

				uncachedPrimaryKeys.remove(amfTrackEventEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AMFTrackEventEntryModelImpl.ENTITY_CACHE_ENABLED,
					AMFTrackEventEntryImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the amf track event entries.
	 *
	 * @return the amf track event entries
	 */
	@Override
	public List<AMFTrackEventEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFTrackEventEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AMFTrackEventEntry> findAll(int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AMFTrackEventEntry> findAll(int start, int end,
		OrderByComparator<AMFTrackEventEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<AMFTrackEventEntry> list = null;

		if (retrieveFromCache) {
			list = (List<AMFTrackEventEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_AMFTRACKEVENTENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AMFTRACKEVENTENTRY;

				if (pagination) {
					sql = sql.concat(AMFTrackEventEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AMFTrackEventEntry>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the amf track event entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMFTrackEventEntry amfTrackEventEntry : findAll()) {
			remove(amfTrackEventEntry);
		}
	}

	/**
	 * Returns the number of amf track event entries.
	 *
	 * @return the number of amf track event entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AMFTRACKEVENTENTRY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMFTrackEventEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf track event entry persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AMFTrackEventEntryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_AMFTRACKEVENTENTRY = "SELECT amfTrackEventEntry FROM AMFTrackEventEntry amfTrackEventEntry";
	private static final String _SQL_SELECT_AMFTRACKEVENTENTRY_WHERE_PKS_IN = "SELECT amfTrackEventEntry FROM AMFTrackEventEntry amfTrackEventEntry WHERE amfTrackEventEntryId IN (";
	private static final String _SQL_SELECT_AMFTRACKEVENTENTRY_WHERE = "SELECT amfTrackEventEntry FROM AMFTrackEventEntry amfTrackEventEntry WHERE ";
	private static final String _SQL_COUNT_AMFTRACKEVENTENTRY = "SELECT COUNT(amfTrackEventEntry) FROM AMFTrackEventEntry amfTrackEventEntry";
	private static final String _SQL_COUNT_AMFTRACKEVENTENTRY_WHERE = "SELECT COUNT(amfTrackEventEntry) FROM AMFTrackEventEntry amfTrackEventEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "amfTrackEventEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AMFTrackEventEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AMFTrackEventEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AMFTrackEventEntryPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}