package com.liferay.training.amf.search.input.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.input.constants.AmfSearchPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchPortletKeys.AmfSearch,
				"mvc.command.name=/submit"
		},
		service = MVCActionCommand.class
)
public class SubmitActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest request, ActionResponse response) throws IOException {
		String zip = ParamUtil.getString(request, "zip");
		response.setRenderParameter("zip", zip);
	}
}
