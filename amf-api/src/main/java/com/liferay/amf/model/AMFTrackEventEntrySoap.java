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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.amf.service.http.AMFTrackEventEntryServiceSoap}.
 *
 * @author Calvin Keum
 * @see com.liferay.amf.service.http.AMFTrackEventEntryServiceSoap
 * @generated
 */
@ProviderType
public class AMFTrackEventEntrySoap implements Serializable {
	public static AMFTrackEventEntrySoap toSoapModel(AMFTrackEventEntry model) {
		AMFTrackEventEntrySoap soapModel = new AMFTrackEventEntrySoap();

		soapModel.setAmfTrackEventEntryId(model.getAmfTrackEventEntryId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setType(model.getType());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static AMFTrackEventEntrySoap[] toSoapModels(
		AMFTrackEventEntry[] models) {
		AMFTrackEventEntrySoap[] soapModels = new AMFTrackEventEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFTrackEventEntrySoap[][] toSoapModels(
		AMFTrackEventEntry[][] models) {
		AMFTrackEventEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFTrackEventEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFTrackEventEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFTrackEventEntrySoap[] toSoapModels(
		List<AMFTrackEventEntry> models) {
		List<AMFTrackEventEntrySoap> soapModels = new ArrayList<AMFTrackEventEntrySoap>(models.size());

		for (AMFTrackEventEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFTrackEventEntrySoap[soapModels.size()]);
	}

	public AMFTrackEventEntrySoap() {
	}

	public long getPrimaryKey() {
		return _amfTrackEventEntryId;
	}

	public void setPrimaryKey(long pk) {
		setAmfTrackEventEntryId(pk);
	}

	public long getAmfTrackEventEntryId() {
		return _amfTrackEventEntryId;
	}

	public void setAmfTrackEventEntryId(long amfTrackEventEntryId) {
		_amfTrackEventEntryId = amfTrackEventEntryId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _amfTrackEventEntryId;
	private Date _createDate;
	private long _userId;
	private String _userName;
	private int _type;
	private String _ipAddress;
}