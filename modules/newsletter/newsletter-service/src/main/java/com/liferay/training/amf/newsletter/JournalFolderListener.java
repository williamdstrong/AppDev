package com.liferay.training.amf.newsletter;


import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
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

	@Override
	public void onAfterCreate(JournalFolder newFolder)
		throws ModelListenerException {

		JournalFolder newsletterFolder = _journalFolderLocalService.fetchFolder(
			_GROUP_ID, _PARENT_FOLDER);
		long newsletterFolderId = newsletterFolder.getFolderId();

		long newFolderParentId = newFolder.getParentFolderId();

		if (newFolderParentId == newsletterFolderId) {
			// The new folder resides with in the newsletter folder and
			// should be treated like a newsletter issue.
			_issueLocalService.createIssue(newFolder);
		}
		super.onAfterCreate(newFolder);
	}

	@Override
	public void onAfterUpdate(JournalFolder journalFolder)
		throws ModelListenerException {
		
		super.onAfterUpdate(journalFolder);
	}

	@Reference
	private JournalFolderLocalService _journalFolderLocalService;

	@Reference
	private IssueLocalService _issueLocalService;
}
