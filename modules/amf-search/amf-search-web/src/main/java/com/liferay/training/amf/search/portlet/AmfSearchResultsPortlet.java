package com.liferay.training.amf.search.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.amf.search.constants.AmfSearchResultsPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=" + AmfSearchResultsPortletKeys.PORTLET_NAME,
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/SearchResults.jsp",
		"javax.portlet.name=" + AmfSearchResultsPortletKeys.AMF_SEARCH_RESULTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supported-processing-event=zip"
	},
	service = Portlet.class
)
public class AmfSearchResultsPortlet extends MVCPortlet {

	@ProcessEvent(qname = "zip")
	public void setZip(EventRequest request, EventResponse response) {
		Event event = request.getEvent();
		String zip = (String) event.getValue();
		response.setRenderParameter("zipSearch", zip);
		response.setRenderParameter("eventFlag", "true");
	}

}
