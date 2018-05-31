package amf.registration.web.portlet;

import amf.registration.web.constants.AmfRegistrationWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.Registration;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

import java.io.IOError;
import java.io.IOException;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=amf-registration-web Portlet",
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

        super.doView(renderRequest, renderResponse);

	}
}