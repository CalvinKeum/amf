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

package com.liferay.amf.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.model.AMFTrackEventEntry;
import com.liferay.amf.service.AMFTrackEventEntryLocalService;
import com.liferay.amf.service.persistence.AMFTrackEventEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the amf track event entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.amf.service.impl.AMFTrackEventEntryLocalServiceImpl}.
 * </p>
 *
 * @author Calvin Keum
 * @see com.liferay.amf.service.impl.AMFTrackEventEntryLocalServiceImpl
 * @see com.liferay.amf.service.AMFTrackEventEntryLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AMFTrackEventEntryLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AMFTrackEventEntryLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.amf.service.AMFTrackEventEntryLocalServiceUtil} to access the amf track event entry local service.
	 */

	/**
	 * Adds the amf track event entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfTrackEventEntry the amf track event entry
	 * @return the amf track event entry that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AMFTrackEventEntry addAMFTrackEventEntry(
		AMFTrackEventEntry amfTrackEventEntry) {
		amfTrackEventEntry.setNew(true);

		return amfTrackEventEntryPersistence.update(amfTrackEventEntry);
	}

	/**
	 * Creates a new amf track event entry with the primary key. Does not add the amf track event entry to the database.
	 *
	 * @param amfTrackEventEntryId the primary key for the new amf track event entry
	 * @return the new amf track event entry
	 */
	@Override
	public AMFTrackEventEntry createAMFTrackEventEntry(
		long amfTrackEventEntryId) {
		return amfTrackEventEntryPersistence.create(amfTrackEventEntryId);
	}

	/**
	 * Deletes the amf track event entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfTrackEventEntryId the primary key of the amf track event entry
	 * @return the amf track event entry that was removed
	 * @throws PortalException if a amf track event entry with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AMFTrackEventEntry deleteAMFTrackEventEntry(
		long amfTrackEventEntryId) throws PortalException {
		return amfTrackEventEntryPersistence.remove(amfTrackEventEntryId);
	}

	/**
	 * Deletes the amf track event entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfTrackEventEntry the amf track event entry
	 * @return the amf track event entry that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AMFTrackEventEntry deleteAMFTrackEventEntry(
		AMFTrackEventEntry amfTrackEventEntry) {
		return amfTrackEventEntryPersistence.remove(amfTrackEventEntry);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(AMFTrackEventEntry.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return amfTrackEventEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return amfTrackEventEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return amfTrackEventEntryPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return amfTrackEventEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return amfTrackEventEntryPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public AMFTrackEventEntry fetchAMFTrackEventEntry(long amfTrackEventEntryId) {
		return amfTrackEventEntryPersistence.fetchByPrimaryKey(amfTrackEventEntryId);
	}

	/**
	 * Returns the amf track event entry with the primary key.
	 *
	 * @param amfTrackEventEntryId the primary key of the amf track event entry
	 * @return the amf track event entry
	 * @throws PortalException if a amf track event entry with the primary key could not be found
	 */
	@Override
	public AMFTrackEventEntry getAMFTrackEventEntry(long amfTrackEventEntryId)
		throws PortalException {
		return amfTrackEventEntryPersistence.findByPrimaryKey(amfTrackEventEntryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(amfTrackEventEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AMFTrackEventEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("amfTrackEventEntryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(amfTrackEventEntryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(AMFTrackEventEntry.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"amfTrackEventEntryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(amfTrackEventEntryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AMFTrackEventEntry.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("amfTrackEventEntryId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return amfTrackEventEntryLocalService.deleteAMFTrackEventEntry((AMFTrackEventEntry)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return amfTrackEventEntryPersistence.findByPrimaryKey(primaryKeyObj);
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
	@Override
	public List<AMFTrackEventEntry> getAMFTrackEventEntries(int start, int end) {
		return amfTrackEventEntryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of amf track event entries.
	 *
	 * @return the number of amf track event entries
	 */
	@Override
	public int getAMFTrackEventEntriesCount() {
		return amfTrackEventEntryPersistence.countAll();
	}

	/**
	 * Updates the amf track event entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param amfTrackEventEntry the amf track event entry
	 * @return the amf track event entry that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AMFTrackEventEntry updateAMFTrackEventEntry(
		AMFTrackEventEntry amfTrackEventEntry) {
		return amfTrackEventEntryPersistence.update(amfTrackEventEntry);
	}

	/**
	 * Returns the amf track event entry local service.
	 *
	 * @return the amf track event entry local service
	 */
	public AMFTrackEventEntryLocalService getAMFTrackEventEntryLocalService() {
		return amfTrackEventEntryLocalService;
	}

	/**
	 * Sets the amf track event entry local service.
	 *
	 * @param amfTrackEventEntryLocalService the amf track event entry local service
	 */
	public void setAMFTrackEventEntryLocalService(
		AMFTrackEventEntryLocalService amfTrackEventEntryLocalService) {
		this.amfTrackEventEntryLocalService = amfTrackEventEntryLocalService;
	}

	/**
	 * Returns the amf track event entry persistence.
	 *
	 * @return the amf track event entry persistence
	 */
	public AMFTrackEventEntryPersistence getAMFTrackEventEntryPersistence() {
		return amfTrackEventEntryPersistence;
	}

	/**
	 * Sets the amf track event entry persistence.
	 *
	 * @param amfTrackEventEntryPersistence the amf track event entry persistence
	 */
	public void setAMFTrackEventEntryPersistence(
		AMFTrackEventEntryPersistence amfTrackEventEntryPersistence) {
		this.amfTrackEventEntryPersistence = amfTrackEventEntryPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.amf.model.AMFTrackEventEntry",
			amfTrackEventEntryLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.amf.model.AMFTrackEventEntry");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AMFTrackEventEntryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AMFTrackEventEntry.class;
	}

	protected String getModelClassName() {
		return AMFTrackEventEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = amfTrackEventEntryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AMFTrackEventEntryLocalService.class)
	protected AMFTrackEventEntryLocalService amfTrackEventEntryLocalService;
	@BeanReference(type = AMFTrackEventEntryPersistence.class)
	protected AMFTrackEventEntryPersistence amfTrackEventEntryPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}