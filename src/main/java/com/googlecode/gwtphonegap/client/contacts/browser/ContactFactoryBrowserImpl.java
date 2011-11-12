package com.googlecode.gwtphonegap.client.contacts.browser;

import com.googlecode.gwtphonegap.client.contacts.ContactAddress;
import com.googlecode.gwtphonegap.client.contacts.ContactFactory;
import com.googlecode.gwtphonegap.client.contacts.ContactField;
import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;

public class ContactFactoryBrowserImpl implements ContactFactory {

	@Override
	public ContactField createContactField(String type, String value, boolean pref) {
		ContactFieldBrowserImpl cf = new ContactFieldBrowserImpl();
		cf.setPref(pref);
		cf.setType(type);
		cf.setValue(value);
		return cf;
	}

	@Override
	public ContactOrganisation createContactOrganisation(String name, String department, String title) {
		ContactOrganisationBrowserImpl contact = new ContactOrganisationBrowserImpl();
		contact.setName(name);
		contact.setDepartment(department);
		contact.setTitle(title);
		return contact;
	}

	@Override
	public ContactAddress createContactAddress(String formatted, String streetAddress, String locality, String region, String postalCode, String country) {
		ContactAddressBrowserImpl ca = new ContactAddressBrowserImpl();
		ca.setCountry(country);
		ca.setFormatted(formatted);
		ca.setLocality(locality);
		ca.setPostalCode(postalCode);
		ca.setRegion(region);
		ca.setStreetAddress(streetAddress);
		return ca;
	}

}
