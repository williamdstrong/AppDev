package com.liferay.training.amf.registration.web.portlet;

import com.liferay.training.amf.registration.web.constants.AmfRegistrationWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.registration.service.RegistrationLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import java.io.IOException;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AMF Registration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AmfRegistrationWebPortletKeys.AmfRegistrationWeb,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AmfRegistrationWebPortlet extends MVCPortlet {

	public void doView(
	        RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {



		ThemeDisplay themeDisplay =
                (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        boolean userIsLoggedIn = themeDisplay.isSignedIn();

        renderRequest.setAttribute("userIsLoggedIn", userIsLoggedIn);
        renderRequest.setAttribute("errors", AmfRegistrationWebUtil.setInitialErrors());

        super.doView(renderRequest, renderResponse);

	}
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected RegistrationLocalService _registrationLocalService;
}