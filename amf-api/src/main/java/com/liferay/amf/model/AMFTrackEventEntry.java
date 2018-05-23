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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AMFTrackEventEntry service. Represents a row in the &quot;AMFTrackEventEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Calvin Keum
 * @see AMFTrackEventEntryModel
 * @see com.liferay.amf.model.impl.AMFTrackEventEntryImpl
 * @see com.liferay.amf.model.impl.AMFTrackEventEntryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.amf.model.impl.AMFTrackEventEntryImpl")
@ProviderType
public interface AMFTrackEventEntry extends AMFTrackEventEntryModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.amf.model.impl.AMFTrackEventEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AMFTrackEventEntry, Long> AMF_TRACK_EVENT_ENTRY_ID_ACCESSOR =
		new Accessor<AMFTrackEventEntry, Long>() {
			@Override
			public Long get(AMFTrackEventEntry amfTrackEventEntry) {
				return amfTrackEventEntry.getAmfTrackEventEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AMFTrackEventEntry> getTypeClass() {
				return AMFTrackEventEntry.class;
			}
		};
}