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

package com.liferay.training.amf.monitor.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AdminMonitor service. Represents a row in the &quot;AMF_AdminMonitor&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorModel
 * @see com.liferay.training.amf.monitor.model.impl.AdminMonitorImpl
 * @see com.liferay.training.amf.monitor.model.impl.AdminMonitorModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.training.amf.monitor.model.impl.AdminMonitorImpl")
@ProviderType
public interface AdminMonitor extends AdminMonitorModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.training.amf.monitor.model.impl.AdminMonitorImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AdminMonitor, Long> MONITOR_ID_ACCESSOR = new Accessor<AdminMonitor, Long>() {
			@Override
			public Long get(AdminMonitor adminMonitor) {
				return adminMonitor.getMonitorId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AdminMonitor> getTypeClass() {
				return AdminMonitor.class;
			}
		};
}