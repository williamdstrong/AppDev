package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.xml.namespace.QName;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchPortletKeys.PORTLET_NAME,
				"mvc.command.name=/submit"
		},
		service = MVCActionCommand.class
)
public class SubmitActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest request, ActionResponse response) {
		String zip = ParamUtil.getString(request, "zip");

		QName qName = new QName("zip");
		response.setEvent(qName, zip);
	}
}
