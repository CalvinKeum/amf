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

package com.liferay.amf.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.amf.model.AMFTrackEventEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMFTrackEventEntry in entity cache.
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntry
 * @generated
 */
@ProviderType
public class AMFTrackEventEntryCacheModel implements CacheModel<AMFTrackEventEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AMFTrackEventEntryCacheModel)) {
			return false;
		}

		AMFTrackEventEntryCacheModel amfTrackEventEntryCacheModel = (AMFTrackEventEntryCacheModel)obj;

		if (amfTrackEventEntryId == amfTrackEventEntryCacheModel.amfTrackEventEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfTrackEventEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{amfTrackEventEntryId=");
		sb.append(amfTrackEventEntryId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", type=");
		sb.append(type);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFTrackEventEntry toEntityModel() {
		AMFTrackEventEntryImpl amfTrackEventEntryImpl = new AMFTrackEventEntryImpl();

		amfTrackEventEntryImpl.setAmfTrackEventEntryId(amfTrackEventEntryId);

		if (createDate == Long.MIN_VALUE) {
			amfTrackEventEntryImpl.setCreateDate(null);
		}
		else {
			amfTrackEventEntryImpl.setCreateDate(new Date(createDate));
		}

		amfTrackEventEntryImpl.setUserId(userId);

		if (userName == null) {
			amfTrackEventEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			amfTrackEventEntryImpl.setUserName(userName);
		}

		amfTrackEventEntryImpl.setType(type);

		if (ipAddress == null) {
			amfTrackEventEntryImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			amfTrackEventEntryImpl.setIpAddress(ipAddress);
		}

		amfTrackEventEntryImpl.resetOriginalValues();

		return amfTrackEventEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		amfTrackEventEntryId = objectInput.readLong();
		createDate = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		type = objectInput.readInt();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(amfTrackEventEntryId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(type);

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long amfTrackEventEntryId;
	public long createDate;
	public long userId;
	public String userName;
	public int type;
	public String ipAddress;
}