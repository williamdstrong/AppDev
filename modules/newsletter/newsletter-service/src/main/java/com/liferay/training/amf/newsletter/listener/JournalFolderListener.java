package com.liferay.training.amf.newsletter.listener;


import com.liferay.journal.model.JournalFolder;
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
public class JournalFolderListener extends BaseModelListener<JournalFolder> {

	/*
	 * This listener will look for folders that have the "Newsletter" folder
	 * as their parent. These folders will be considered issues.
	 *
	 */

	private static final String _PARENT_FOLDER = "Newsletter";
	private static final long _GROUP_ID = 20142;

	/*
	 * During creation a folder which is an issue needs to be added as one.
	 * This method confirms that the folder is being made inside the Newsletter
	 * folder and creates an issue for the folder.
	 */
	@Override
	public void onAfterCreate(JournalFolder newFolder)
		throws ModelListenerException {

		if (_isInNewsletterFolder(newFolder)) {
			// The new folder resides with in the newsletter folder and
			// should be treated like a newsletter issue.
			_issueLocalService.addIssue(newFolder);
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
		// location.
		return (oldIsAnIssue && !newIsAnIssue);

	}

	private boolean _isInNewsletterFolder(JournalFolder journalFolder) {
		JournalFolder newsletterFolder = _journalFolderLocalService.fetchFolder(
			_GROUP_ID, _PARENT_FOLDER);
		long newsletterFolderId = newsletterFolder.getFolderId();

		long journalFolderParentId = journalFolder.getParentFolderId();

		return journalFolderParentId == newsletterFolderId;
	}

	@Reference
	private JournalFolderLocalService _journalFolderLocalService;

	@Reference
	private IssueLocalService _issueLocalService;

	Log _log = LogFactoryUtil.getLog(JournalFolderListener.class);
}
