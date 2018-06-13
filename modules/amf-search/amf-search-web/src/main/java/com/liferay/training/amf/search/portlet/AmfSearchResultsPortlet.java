package com.liferay.training.amf.search.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import com.liferay.training.amf.search.constants.AmfSearchResultsPortletKeys;
import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=amf-search-results Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/SearchResults.jsp",
		"javax.portlet.name=" + AmfSearchResultsPortletKeys.AmfSearchResults,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supported-public-render-parameter=zip"
	},
	service = Portlet.class
)
public class AmfSearchResultsPortlet extends MVCPortlet {
}