package com.liferay.training.amf.searchresults.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.training.amf.search.service.SearchService;
import com.liferay.training.amf.search.service.SearchServiceUtil;

import java.util.LinkedList;
import java.util.List;

public class DataFormatter {

	public List<SearchData> getFormattedData(String zip, int start, int end) {
		List<User> users = null;
		List<SearchData> searchData = new LinkedList<>();
		try {
			users = getUsers(zip, start, end);
		} catch (PortalException e) {
			return searchData;
		}

		for (User u : users) {
			searchData.add(new SearchData(getFirstName(u), getLastInitial(u), getScreenName(u), getEmailAddress(u)));
		}
		return searchData;
	}

	private String getFirstName(User u) {
		return u.getFirstName();
	}

	private String getLastInitial(User u) {
		String lastName = u.getLastName();
		return String.valueOf(lastName.charAt(0));
	}

	private String getScreenName(User u) {
		return u.getScreenName();
	}

	private String getEmailAddress(User u) {
		return u.getEmailAddress();
	}

	private List<User> getUsers(String zip, int start, int end) throws PortalException {
		return SearchServiceUtil.findUsersByZip(zip, start, end);
	}

}
