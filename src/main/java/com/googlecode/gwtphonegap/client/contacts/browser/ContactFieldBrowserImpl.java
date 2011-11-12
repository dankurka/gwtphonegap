package com.googlecode.gwtphonegap.client.contacts.browser;

import com.googlecode.gwtphonegap.client.contacts.ContactField;

public class ContactFieldBrowserImpl implements ContactField {

	private String type;
	private String value;
	private boolean pref;

	@Override
	public void setType(String type) {
		this.type = type;

	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setValue(String value) {
		this.value = value;

	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setPref(boolean pref) {
		this.pref = pref;

	}

	@Override
	public boolean isPref() {
		return pref;
	}

}
