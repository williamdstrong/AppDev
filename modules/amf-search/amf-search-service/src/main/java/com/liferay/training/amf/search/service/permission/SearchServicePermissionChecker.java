package com.liferay.training.amf.search.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.training.amf.search.service.SearchService;
import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true
)
public class SearchServicePermissionChecker implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException {

		if (!_hasPermission(permissionChecker, groupId, actionId)) {
			// Handle by returning a no go.
			throw new PrincipalException.MustHavePermission(permissionChecker, SearchService.class.getName(), actionId);
		}
	}


	private static boolean _hasPermission(
			PermissionChecker permissionChecker, long groupId, String actionId) {
		return permissionChecker.hasPermission(groupId, SearchService.class.getName(), 0, actionId);
	}

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {

		check(permissionChecker, groupId, actionId);

	}
}