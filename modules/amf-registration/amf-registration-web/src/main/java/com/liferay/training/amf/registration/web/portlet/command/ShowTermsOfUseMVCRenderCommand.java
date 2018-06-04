package com.liferay.training.amf.registration.web.portlet.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.registration.web.constants.AmfRegistrationWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + AmfRegistrationWebPortletKeys.AmfRegistrationWeb,
                "mvc.command.name=/terms"
        },
        service = MVCRenderCommand.class
)
public class ShowTermsOfUseMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response) {

        return "/terms_of_use.jsp";
    }
}
