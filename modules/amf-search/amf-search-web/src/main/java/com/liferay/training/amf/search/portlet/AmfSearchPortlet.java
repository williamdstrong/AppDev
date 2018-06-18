package com.liferay.training.amf.search.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + AmfSearchPortletKeys.PORTLET_DISPLAY_NAME,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/SearchInput.jsp",
		"javax.portlet.name=" + AmfSearchPortletKeys.PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supported-publishing-event=zip"
	},
	service = Portlet.class
)
public class AmfSearchPortlet extends MVCPortlet {
}