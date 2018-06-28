package com.liferay.training.amf.newsletter;

import com.liferay.journal.exception.InvalidDDMStructureException;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.service.JournalArticleLocalServiceWrapper;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.xml.DocumentException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author William Strong
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class JournalArticleLocalServiceOverride extends JournalArticleLocalServiceWrapper {

	public JournalArticleLocalServiceOverride() {
		super(null);
	}

	@Override
	public JournalArticle moveArticle(
		long groupId, String articleId, long newFolderId, ServiceContext serviceContext)
		throws PortalException {

		long count = UserLocalServiceUtil.getUsersCount();

		JournalArticle journalArticle =
			getArticle(Long.parseLong(articleId));


		try {
			if (_articleIsMovingFromNewsletterFolder(journalArticle, newFolderId) &&
				_articleIsIssueData(journalArticle)) {

				// The Issue data should not be removed from the folder. The
				// user should be warned.

				_log.error(_buildErrorMessage(journalArticle));
				throw new InvalidDDMStructureException(_buildErrorMessage(
					journalArticle));
			}
			else {
				return super.moveArticle(groupId, articleId, newFolderId, serviceContext);
			}
		}
		catch (DocumentException e) {
			_log.error(e, e);
			throw new PortalException(e);
		}
	}

	@Override
	public JournalArticle getArticle(long articleId) throws PortalException {
		return super.getArticle(articleId);
	}

	private String _buildErrorMessage(JournalArticle journalArticle) {
		try {
			StringBundler s = new StringBundler();
			s.append("DDM Structure is ");
			s.append(journalArticle.getDDMStructure().getName());
			s.append(", but it should be ");
			s.append(NewsletterServiceKeys.ISSUE_DATA_STRUCTURE_NAME);
			s.append(".");
			return s.toString();
		}
		catch (PortalException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}
	}

	private boolean _isInNewsletterFolder(JournalFolder journalFolder){
		JournalFolder newsletterFolder = _journalFolderLocalService.fetchFolder(
			NewsletterServiceKeys.GROUP_ID,
			NewsletterServiceKeys.PARENT_FOLDER);
		long newsletterFolderId = newsletterFolder.getFolderId();

		long journalFolderParentId = journalFolder.getParentFolderId();

		return journalFolderParentId == newsletterFolderId;
	}

	private boolean _articleIsIssueData(JournalArticle journalArticle)
		throws DocumentException, PortalException {

		return ArticleChecks.hasDDMStructure(
			journalArticle, NewsletterServiceKeys.ISSUE_DATA_STRUCTURE_NAME);
	}



	private boolean _articleIsMovingFromNewsletterFolder(
		JournalArticle newArticle, long newFolderId) throws PortalException {

		JournalFolder newArticleFolder;
		JournalFolder originalArticleFolder;

		try {
			originalArticleFolder =_journalFolderLocalService.getFolder(newFolderId);
			newArticleFolder = newArticle.getFolder();
		}
		catch (PortalException e) {
			_log.error(e);
			throw new PortalException(e);
		}

		boolean newIsAnIssue = _isInNewsletterFolder(newArticleFolder);
		boolean oldIsAnIssue = _isInNewsletterFolder(originalArticleFolder);

		// In this case the folder is moving from the parent to another
		// parent.
		return (oldIsAnIssue && !newIsAnIssue);

	}

	@Reference
	private JournalFolderLocalService _journalFolderLocalService;

	private Log _log = LogFactoryUtil.getLog(JournalArticleLocalServiceOverride.class.getName());

	@Reference(unbind = "-")
	private void serviceSetter(JournalArticleLocalService journalArticleLocalService) {
		setWrappedService(journalArticleLocalService);
	}
}

