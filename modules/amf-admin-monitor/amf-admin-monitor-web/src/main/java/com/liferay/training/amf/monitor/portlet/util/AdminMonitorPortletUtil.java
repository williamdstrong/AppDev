package com.liferay.training.amf.monitor.portlet.util;

import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.service.AdminMonitorLocalService;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import java.util.List;

public class AdminMonitorUtil {

	public enum EventTypes {
		String create = "create";
		String 
	}

	public int getSize(String eventType) {
		return 100;
	}

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected AdminMonitorLocalService _adminMonitorLocalService;
}
