/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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
	public ContactOrganisation createContactOrganisation(String name, String department, String title,boolean pref,String type) {
		ContactOrganisationBrowserImpl contact = new ContactOrganisationBrowserImpl();
		contact.setName(name);
		contact.setDepartment(department);
		contact.setTitle(title);
        contact.setPref(pref);
        contact.setType(type);
		return contact;
	}

	@Override
	public ContactAddress createContactAddress(String type,boolean isPref, String streetAddress, String locality, String region, String postalCode, String country) {
		ContactAddressBrowserImpl ca = new ContactAddressBrowserImpl();
		ca.setCountry(country);
		ca.setLocality(locality);
		ca.setPostalCode(postalCode);
		ca.setRegion(region);
		ca.setStreetAddress(streetAddress);
        ca.setType(type);
        ca.setPref(isPref);
		return ca;
	}

}
