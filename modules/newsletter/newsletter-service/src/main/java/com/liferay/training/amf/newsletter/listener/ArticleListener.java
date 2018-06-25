package com.liferay.training.amf.newsletter.listener;


import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
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
public class ArticleListener extends BaseModelListener<JournalArticle> {

	/**
	 * On the update of a new article we need to ensure that it is or isn't
	 * an article for the newsletter.
	 *
	 * Newsletter articles will be store in newsletter folders. The
     * IssueLocalService will provide a method which returns a list with all
	 * of the folders that are newsletter folders. This will be curated by
	 * the FolderListener.
	 *
	 * The article will only be added to the issue if it:
	 *
	 *   is inside a subfolder of the newsletter folder (checked with
	 *   _isInNewsletterFolder(JournalArticle))
	 *
	 *   does not conflict with the date of the issue (checked with
	 *   _issueDateIsConsistent(JournalArticle))
	 *
	 *   does not conflict with the number of the issue (checked with
	 *   _issueNumberIsConsistent(JournalArticle))
	 *
	 *   was created with the AMF Newsletter structure (checked with
	 *   _articleIsAnNewsletterArticle(JournalArticle))
	 *
	 * User error is going to be a huge factor into this design. The user may be
	 * able to easily do things in a way that breaks my code.
	 *
	 * There is also currently no way to change the issue without having to
	 * change each and every article. An option for this is to add a structure
	 * for setting the issue data. This may be a good option, but there is a lot
	 * of data handling and synchronization that will need to be done. This
	 * includes ensuring that the title and the description are maintained
	 * consistent between a data file and the folder.
	 *
	 * Another option is not making the newsletter issue live until the data
	 * file has been added to the folder. This will be very frustrating to a
	 * user who does not know that feature needs to be there, but may help
	 * alleviate other problems.
	 *
	 *
	 */
	@Override
	public void onAfterCreate(JournalArticle journalArticle)
		throws ModelListenerException {




		try {

			if (_isIssueData(journalArticle)) {
				_articleLocalService.addIssueMetaData(journalArticle);
			}

			if (_articleIsValid(journalArticle)) {

			}
		}
		catch (PortalException | DocumentException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}
		super.onAfterCreate(journalArticle);
	}

	/**
	 *
	 * Updates can be moving the article to another folder (newsletter issue) or
	 * removing the article from the issue entirely.
	 *
	 * In the case of a move that is outside of the scope of the Newsletter
	 * folder the issue does not need to be edited.
	 *
	 * If an article is moved in it should be validated and checked for
	 * approval.
	 *
	 */
	@Override
	public void onAfterUpdate(JournalArticle journalArticle)
		throws ModelListenerException {

		super.onAfterUpdate(journalArticle);
	}

	private boolean _isIssueData(JournalArticle journalArticle) {
		DDMStructure structure;
		try {
			structure = journalArticle.getDDMStructure();
		}
		catch (PortalException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}
		String name = structure.getName();

		Document document;
		try {
			document = SAXReaderUtil.read(name);
		}
		catch (DocumentException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}

		Node nameNode = document.selectSingleNode(
			"/root/Name");
		name = nameNode.getText();

		return (name.equals(ListenerConstants.ISSUE_STRUCTURE));
	}

	private boolean _articleIsValid(JournalArticle journalArticle) {

		JournalFolder journalFolder;

		try {
			journalFolder = journalArticle.getFolder();
		}
		catch (PortalException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}
		return _isInNewsletterFolder(journalFolder) &&
			   _issueDateIsConsistent(journalArticle) &&
			   _issueNumberIsConsistent(journalArticle);
	}

	/**
	 * TODO
	 *
	 * The issue date is considered consistent if the other articles inside the
	 * folder have a issue date that is the same.
	 *
	 * @param journalArticle the journal article that is being created or
	 *                          updated
	 *
	 * @return true if the date is consistent; false otherwise.
	 */
	private boolean _issueDateIsConsistent(JournalArticle journalArticle) {
		return true;
	}

	/**
	 * TODO
	 *
	 * The issue number is considered consistent if the other articles inside the
	 * folder have a issue number that is the same.
	 *
	 * @param journalArticle the journal article that is being created or
	 *                          updated
	 *
	 * @return true if the number is consistent; false otherwise.
	 */
	private boolean _issueNumberIsConsistent(JournalArticle journalArticle) {
		return true;
	}

	private boolean _articleIsMovingFromNewsletterFolder(
		JournalArticle newArticle) {

		JournalArticle originalArticle;
		JournalFolder newArticleFolder;
		JournalFolder originalArticleFolder;

		try {
			originalArticle =
				_journalArticleLocalService.getArticle(newArticle.getId());

			originalArticleFolder = originalArticle.getFolder();
			newArticleFolder = newArticle.getFolder();
		}
		catch (PortalException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}


		boolean newIsAnIssue = _isInNewsletterFolder(newArticleFolder);
		boolean oldIsAnIssue = _isInNewsletterFolder(originalArticleFolder);

		// In this case the folder is moving from the parent to another
		// parent.
		return (oldIsAnIssue && !newIsAnIssue);

	}

	private boolean _isInNewsletterFolder(JournalFolder journalFolder){
		JournalFolder newsletterFolder = _journalFolderLocalService.fetchFolder(
			ListenerConstants.GROUP_ID, ListenerConstants.PARENT_FOLDER);
		long newsletterFolderId = newsletterFolder.getFolderId();

		long journalFolderParentId = journalFolder.getParentFolderId();

		return journalFolderParentId == newsletterFolderId;
	}


	@Reference
	private JournalFolderLocalService _journalFolderLocalService;

	@Reference
	private JournalArticleLocalService _journalArticleLocalService;

	@Reference
	private ArticleLocalService _articleLocalService;

	Log _log = LogFactoryUtil.getLog(ArticleListener.class);
}
