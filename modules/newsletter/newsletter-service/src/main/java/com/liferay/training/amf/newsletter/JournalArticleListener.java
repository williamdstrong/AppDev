package com.liferay.training.amf.newsletter;


import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.training.amf.newsletter.service.ArticleLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author William Strong
 */
@Component(
	immediate = true,
	service = ModelListener.class
)
public class JournalArticleListener extends BaseModelListener<JournalArticle> {

	/*
	 * On the update of a new article we need to ensure that it is or isn't
	 * an article for the newsletter.
	 *
	 * Newsletter articles will be store in newsletter folders. The
     * IssueLocalService will provide a method which returns a list with all
	 * of the folders that are newsletter folders. This will be curated by
	 * the JournalFolderListener.
	 *
	 */
	@Override
	public void onAfterCreate(JournalArticle journalArticle)
		throws ModelListenerException {

		super.onAfterCreate(journalArticle);
	}

	@Override
	public void onAfterUpdate(JournalArticle journalArticle)
		throws ModelListenerException {

		super.onAfterUpdate(journalArticle);
	}

	@Reference
	private ArticleLocalService _articleLocalService;
}
