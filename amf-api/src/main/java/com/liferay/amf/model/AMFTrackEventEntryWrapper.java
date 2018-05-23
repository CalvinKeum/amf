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

package com.liferay.amf.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link AMFTrackEventEntry}.
 * </p>
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntry
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryWrapper implements AMFTrackEventEntry,
	ModelWrapper<AMFTrackEventEntry> {
	public AMFTrackEventEntryWrapper(AMFTrackEventEntry amfTrackEventEntry) {
		_amfTrackEventEntry = amfTrackEventEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return AMFTrackEventEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AMFTrackEventEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("amfTrackEventEntryId", getAmfTrackEventEntryId());
		attributes.put("createDate", getCreateDate());
		attributes.put("userId", getUserId());
		attributes.put("type", getType());
		attributes.put("ipAddress", getIpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long amfTrackEventEntryId = (Long)attributes.get("amfTrackEventEntryId");

		if (amfTrackEventEntryId != null) {
			setAmfTrackEventEntryId(amfTrackEventEntryId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public AMFTrackEventEntry toEscapedModel() {
		return new AMFTrackEventEntryWrapper(_amfTrackEventEntry.toEscapedModel());
	}

	@Override
	public AMFTrackEventEntry toUnescapedModel() {
		return new AMFTrackEventEntryWrapper(_amfTrackEventEntry.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _amfTrackEventEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _amfTrackEventEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _amfTrackEventEntry.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _amfTrackEventEntry.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AMFTrackEventEntry> toCacheModel() {
		return _amfTrackEventEntry.toCacheModel();
	}

	@Override
	public int compareTo(AMFTrackEventEntry amfTrackEventEntry) {
		return _amfTrackEventEntry.compareTo(amfTrackEventEntry);
	}

	/**
	* Returns the type of this amf track event entry.
	*
	* @return the type of this amf track event entry
	*/
	@Override
	public int getType() {
		return _amfTrackEventEntry.getType();
	}

	@Override
	public int hashCode() {
		return _amfTrackEventEntry.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amfTrackEventEntry.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AMFTrackEventEntryWrapper((AMFTrackEventEntry)_amfTrackEventEntry.clone());
	}

	/**
	* Returns the ip address of this amf track event entry.
	*
	* @return the ip address of this amf track event entry
	*/
	@Override
	public java.lang.String getIpAddress() {
		return _amfTrackEventEntry.getIpAddress();
	}

	/**
	* Returns the user uuid of this amf track event entry.
	*
	* @return the user uuid of this amf track event entry
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _amfTrackEventEntry.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _amfTrackEventEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _amfTrackEventEntry.toXmlString();
	}

	/**
	* Returns the create date of this amf track event entry.
	*
	* @return the create date of this amf track event entry
	*/
	@Override
	public Date getCreateDate() {
		return _amfTrackEventEntry.getCreateDate();
	}

	/**
	* Returns the amf track event entry ID of this amf track event entry.
	*
	* @return the amf track event entry ID of this amf track event entry
	*/
	@Override
	public long getAmfTrackEventEntryId() {
		return _amfTrackEventEntry.getAmfTrackEventEntryId();
	}

	/**
	* Returns the primary key of this amf track event entry.
	*
	* @return the primary key of this amf track event entry
	*/
	@Override
	public long getPrimaryKey() {
		return _amfTrackEventEntry.getPrimaryKey();
	}

	/**
	* Returns the user ID of this amf track event entry.
	*
	* @return the user ID of this amf track event entry
	*/
	@Override
	public long getUserId() {
		return _amfTrackEventEntry.getUserId();
	}

	@Override
	public void persist() {
		_amfTrackEventEntry.persist();
	}

	/**
	* Sets the amf track event entry ID of this amf track event entry.
	*
	* @param amfTrackEventEntryId the amf track event entry ID of this amf track event entry
	*/
	@Override
	public void setAmfTrackEventEntryId(long amfTrackEventEntryId) {
		_amfTrackEventEntry.setAmfTrackEventEntryId(amfTrackEventEntryId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_amfTrackEventEntry.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this amf track event entry.
	*
	* @param createDate the create date of this amf track event entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_amfTrackEventEntry.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_amfTrackEventEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_amfTrackEventEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_amfTrackEventEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ip address of this amf track event entry.
	*
	* @param ipAddress the ip address of this amf track event entry
	*/
	@Override
	public void setIpAddress(java.lang.String ipAddress) {
		_amfTrackEventEntry.setIpAddress(ipAddress);
	}

	@Override
	public void setNew(boolean n) {
		_amfTrackEventEntry.setNew(n);
	}

	/**
	* Sets the primary key of this amf track event entry.
	*
	* @param primaryKey the primary key of this amf track event entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_amfTrackEventEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_amfTrackEventEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type of this amf track event entry.
	*
	* @param type the type of this amf track event entry
	*/
	@Override
	public void setType(int type) {
		_amfTrackEventEntry.setType(type);
	}

	/**
	* Sets the user ID of this amf track event entry.
	*
	* @param userId the user ID of this amf track event entry
	*/
	@Override
	public void setUserId(long userId) {
		_amfTrackEventEntry.setUserId(userId);
	}

	/**
	* Sets the user uuid of this amf track event entry.
	*
	* @param userUuid the user uuid of this amf track event entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_amfTrackEventEntry.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFTrackEventEntryWrapper)) {
			return false;
		}

		AMFTrackEventEntryWrapper amfTrackEventEntryWrapper = (AMFTrackEventEntryWrapper)obj;

		if (Objects.equals(_amfTrackEventEntry,
					amfTrackEventEntryWrapper._amfTrackEventEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public AMFTrackEventEntry getWrappedModel() {
		return _amfTrackEventEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _amfTrackEventEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _amfTrackEventEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_amfTrackEventEntry.resetOriginalValues();
	}

	private final AMFTrackEventEntry _amfTrackEventEntry;
}