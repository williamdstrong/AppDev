package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.constants.PermissionKeys;
import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchPortletKeys.PORTLET_NAME,
				"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)
public class SearchInputRenderCommand implements MVCRenderCommand {

	private static PermissionChecker _getPermissionChecker(ThemeDisplay themeDisplay) {
		if (null == themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}
		return themeDisplay.getPermissionChecker();
	}

	private static long _getGroupId(ThemeDisplay themeDisplay) {
		if (null == themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}
		return themeDisplay.getScopeGroupId();
	}

	private static ThemeDisplay _getThemeDisplay(PortletRequest request) {
		if (null == request) {
			throw new IllegalArgumentException("request is null");
		}

		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		ThemeDisplay themeDisplay = _getThemeDisplay(request);
		PermissionChecker permissionChecker = _getPermissionChecker(themeDisplay);
		long groupId = _getGroupId(themeDisplay);

		boolean hasPermission = permissionChecker.hasPermission(
				groupId, AmfSearchPortletKeys.PORTLET_NAME, 0, PermissionKeys.canMakeSearch);
		if (!hasPermission) {
			return "/NoPermission.jsp";
		}

		SessionMessages.clear(request);
		return "/SearchInput.jsp";
	}
}
