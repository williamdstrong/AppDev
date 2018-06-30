package com.liferay.training.amf.newsletter.portlet.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.training.amf.newsletter.Article;
import com.liferay.training.amf.newsletter.constants.NewsletterPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + NewsletterPortletKeys.Newsletter,
		"mvc.command.name=article"
	},
	service = MVCRenderCommand.class
)
public class ArticleRenderCommand implements MVCRenderCommand {

	public String render(RenderRequest request, RenderResponse response) {

		long articleId = ParamUtil.getLong(request, "article");

		Article article = null;
		try {
			article = new Article(articleId);
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		catch (DocumentException e) {
			e.printStackTrace();
		}
		request.setAttribute("article", article);

		return "/article.jsp";
	}
}
