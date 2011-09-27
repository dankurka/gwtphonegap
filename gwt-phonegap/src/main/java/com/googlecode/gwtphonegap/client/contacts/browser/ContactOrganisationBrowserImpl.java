package com.googlecode.gwtphonegap.client.contacts.browser;

import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;

public class ContactOrganisationBrowserImpl implements ContactOrganisation {

	private String name;
	private String department;
	private String title;

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setDepartment(String department) {
		this.department = department;

	}

	@Override
	public String getDepartment() {
		return department;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;

	}

	@Override
	public String getTitle() {
		return title;
	}

}
