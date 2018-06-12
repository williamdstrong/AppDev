package com.liferay.training.amf.search.portlet.util;

public class SearchData {

	public SearchData(String firstName, String lastInitial, String screenName, String emailAddress) {
		this.firstName = firstName;
		this.lastInitial = lastInitial;
		this.screenName = screenName;
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getLastInitial() {

		return lastInitial;
	}

	public void setLastInitial(String lastInitial) {
		this.lastInitial = lastInitial;
	}

	private String firstName;
	private String lastInitial;
	private String screenName;
	private String emailAddress;
}
