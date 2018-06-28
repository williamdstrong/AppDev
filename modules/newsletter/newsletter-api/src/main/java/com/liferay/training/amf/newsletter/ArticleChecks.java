package com.liferay.training.amf.newsletter;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

public class ArticleChecks {

	public static boolean hasDDMStructure(
		JournalArticle journalArticle, String structureName)
		throws PortalException, DocumentException {

		DDMStructure structure;
			structure = journalArticle.getDDMStructure();

		String name = structure.getName();

		Document document = SAXReaderUtil.read(name);

		Node nameNode = document.selectSingleNode(
			"/root/Name");
		name = nameNode.getText();

		return (name.equals(structureName));
	}
}
