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
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Article. This utility wraps
 * {@link com.liferay.training.amf.newsletter.service.impl.ArticleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleLocalService
 * @see com.liferay.training.amf.newsletter.service.base.ArticleLocalServiceBaseImpl
 * @see com.liferay.training.amf.newsletter.service.impl.ArticleLocalServiceImpl
 * @generated
 */
@ProviderType
public class ArticleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.newsletter.service.impl.ArticleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addIssueMetaData(
		com.liferay.journal.model.JournalArticle journalArticle)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.xml.DocumentException {
		getService().addIssueMetaData(journalArticle);
	}

	public static com.liferay.training.amf.newsletter.dto.NewsletterArticle getArticle(
		long journalId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.xml.DocumentException {
		return getService().getArticle(journalId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ArticleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArticleLocalService, ArticleLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArticleLocalService.class);

		ServiceTracker<ArticleLocalService, ArticleLocalService> serviceTracker = new ServiceTracker<ArticleLocalService, ArticleLocalService>(bundle.getBundleContext(),
				ArticleLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}