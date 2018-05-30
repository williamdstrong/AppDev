package amf.registration.web.portlet;

import amf.registration.web.constants.AmfRegistrationWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.servlet.Registration;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;

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

	public void foo(RenderRequest r) {
		ThemeDisplay themeDisplay = (ThemeDisplay)r.getAttribute(WebKeys.THEME_DISPLAY);

//		themeDisplay.getUser().getuser



//		Registration registration = Registration
	}
}