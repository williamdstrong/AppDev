package com.liferay.training.amf.monitor.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.training.amf.monitor.model.AdminMonitor;
import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = "model.class.name=com.liferay.training.amf.monitor.model.AdminMonitor"
)
public class AdminMonitorPermissionChecker implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		 if (!_hasPermission(permissionChecker, groupId, actionId)) {
			// Handle by returning a no go.
			throw new PrincipalException.MustHavePermission(permissionChecker, AdminMonitor.class.getName(), actionId);
		}
	}


	private static boolean _hasPermission(
			PermissionChecker permissionChecker, long groupId, String actionId) {
		return permissionChecker.hasPermission(groupId, AdminMonitor.class.getName(), 0, actionId);
	}

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {

		check(permissionChecker, groupId, actionId);

	}
}
