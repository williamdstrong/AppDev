/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.newsletter.service;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.training.amf.newsletter.dto.JournalArticle;

/**
 * Provides a wrapper for {@link ArticleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleLocalService
 * @generated
 */
@ProviderType
public class ArticleLocalServiceWrapper implements ArticleLocalService,
	ServiceWrapper<ArticleLocalService> {
	public ArticleLocalServiceWrapper(ArticleLocalService articleLocalService) {
		_articleLocalService = articleLocalService;
	}

	@Override
	public void addIssueMetaData(
		com.liferay.journal.model.JournalArticle journalArticle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.xml.DocumentException {
		_articleLocalService.addIssueMetaData(journalArticle);
	}

	@Override
	public JournalArticle getArticle(
		long journalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.xml.DocumentException {
		return _articleLocalService.getArticle(journalId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public ArticleLocalService getWrappedService() {
		return _articleLocalService;
	}

	@Override
	public void setWrappedService(ArticleLocalService articleLocalService) {
		_articleLocalService = articleLocalService;
	}

	private ArticleLocalService _articleLocalService;
}