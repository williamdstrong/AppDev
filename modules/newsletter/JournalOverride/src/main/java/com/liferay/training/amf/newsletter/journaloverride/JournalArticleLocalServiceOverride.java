package com.liferay.training.amf.newsletter.journaloverride;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.NewsletterServiceKeys;
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

		JournalArticle journalArticle =
			getArticle(groupId, articleId);


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
		if (journalFolder == null) {
			return false;
		}

		JournalFolder newsletterFolder = _journalFolderLocalService.fetchFolder(
			NewsletterServiceKeys.GROUP_ID,
			NewsletterServiceKeys.PARENT_FOLDER);
		long newsletterFolderId = newsletterFolder.getFolderId();

		long journalFolderParentId = journalFolder.getParentFolderId();

		return journalFolderParentId == newsletterFolderId;
	}

	private boolean _articleIsIssueData(JournalArticle journalArticle)
		throws DocumentException, PortalException {

		return hasDDMStructure(
			journalArticle, NewsletterServiceKeys.ISSUE_DATA_STRUCTURE_NAME);
	}

	private static boolean hasDDMStructure(
		JournalArticle journalArticle, String structureName)
		throws PortalException, DocumentException {

		String name = _getDDMStructureName(journalArticle);

		return (name.equals(structureName));
	}

	private static String _getDDMStructureName(JournalArticle journalArticle) throws PortalException, DocumentException {

		DDMStructure structure;
		structure = journalArticle.getDDMStructure();

		String name = structure.getName();

		Document document = SAXReaderUtil.read(name);

		Node nameNode = document.selectSingleNode(
			"/root/Name");
		
		return nameNode.getText();
	}

	private boolean _articleIsMovingFromNewsletterFolder(
		JournalArticle article, long newFolderId) throws PortalException {

		JournalFolder newArticleFolder;
		JournalFolder originalArticleFolder;

		try {
			if (!(newFolderId == 0)) {
				newArticleFolder = _journalFolderLocalService.getFolder(newFolderId);
			}
			else {
				newArticleFolder = null;
			}
			originalArticleFolder = article.getFolder();
		}
		catch (PortalException e) {
			_log.error(e);
			throw new PortalException(e);
		}

		boolean newIsAnIssue = _isInNewsletterFolder(newArticleFolder);
		boolean oldIsAnIssue = _isInNewsletterFolder(originalArticleFolder);

		// In this case the folder is moving from the parent to another
		// parent.

		if (!oldIsAnIssue) {
			return false;
		}
		else {
			return (!newIsAnIssue);
		}
	}


	@Reference
	private JournalFolderLocalService _journalFolderLocalService;

	private Log _log = LogFactoryUtil.getLog(JournalArticleLocalServiceOverride.class.getName());

	@Reference(unbind = "-")
	private void serviceSetter(JournalArticleLocalService journalArticleLocalService) {
		setWrappedService(journalArticleLocalService);
	}
}


