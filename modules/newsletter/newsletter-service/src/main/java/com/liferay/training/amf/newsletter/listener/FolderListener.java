package com.liferay.training.amf.newsletter.listener;


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
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.IssueLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author William Strong
 */
@Component(
	immediate = true,
	service = ModelListener.class
)
public class FolderListener extends BaseModelListener<JournalFolder> {

	/*
	 * During creation a folder which is an issue needs to be added as one.
	 * This method confirms that the folder is being made inside the Newsletter
	 * folder and creates an issue for the folder.
	 */
	@Override
	public void onAfterCreate(JournalFolder newFolder)
		throws ModelListenerException {

		if (_isInNewsletterFolder(newFolder)) {
			// The creation of a new issue should also create a new
			// article of the Newsletter Issue type which holds
			// metadata for the issue.
			_addIssue(newFolder);
		}
		super.onAfterCreate(newFolder);
	}

	/*
	 * Updates to the folders can mean updates to the folders inside the
	 * Newsletter folder. When folders inside newsletter are updated then the
	 * corresponding issue should be updated as well.
	 *
	 * Checks whether the folder is in (or going to be in) the Newsletter
	 * folder, then handles the change in the issue tables.
	 */
	@Override
	public void onBeforeUpdate(JournalFolder journalFolder)
		throws ModelListenerException {

		// Get the original folder. If there is no original folder, then there
		// is a serious issue.


		// The parents of the folders needs to be compared...
		// Check if the original parent was the Newsletter folder and if it has
		// moved from there then we need to remove the issue.
		if (_folderIsMovingFromNewsletterFolder(journalFolder)) {
			Issue movedIssue = null;
			try {
				movedIssue = _issueLocalService.getIssueByFolderId(journalFolder.getFolderId());
			}
			catch (PortalException e) {
				_log.error(e, e);
				throw new ModelListenerException(e);
			}
			_issueLocalService.deleteIssue(movedIssue);
		}
		super.onAfterUpdate(journalFolder);
	}


	@Override
	public void onAfterUpdate(JournalFolder journalFolder) {
		if (_isInNewsletterFolder(journalFolder)) {
			System.out.println(journalFolder);

		}
		super.onAfterUpdate(journalFolder);
	}

	/*
	 * Adds the journal folder as an issue and ensures that an issue metadata article
	 * is inside the folder.
	 * 
	 */
	private void _addIssue(JournalFolder journalFolder) {
		
		// The new folder resides with in the newsletter folder and
		// should be treated like a newsletter issue.
		_issueLocalService.addIssue(newFolder);


		JournalArticle journalArticle;

		_journalArticleLocalService.addJournalArticle(journalArticle);
	}

	private boolean _folderIsMovingFromNewsletterFolder(JournalFolder newFolder) {
		JournalFolder originalFolder;
		try {
			originalFolder =
				_journalFolderLocalService.getJournalFolder(newFolder.getFolderId());
		}
		catch (PortalException e) {
			_log.error(e, e);
			throw new ModelListenerException(e);
		}

		boolean newIsAnIssue = _isInNewsletterFolder(newFolder);
		boolean oldIsAnIssue = _isInNewsletterFolder(originalFolder);

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
	private IssueLocalService _issueLocalService;

	private Log _log = LogFactoryUtil.getLog(FolderListener.class);
}
