/*
 * Copyright 2010 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.contacts.js;

import com.googlecode.gwtphonegap.client.contacts.ContactAddress;
import com.googlecode.gwtphonegap.client.contacts.ContactFactory;
import com.googlecode.gwtphonegap.client.contacts.ContactField;
import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;

public class ContactFactoryJsoImpl implements ContactFactory {

	@Override
	public native ContactField createContactField(String type, String value, boolean pref) /*-{
		return new $wnd.ContactField(type, value, pref);
	}-*/;

	@Override
	public native ContactOrganisation createContactOrganisation(String name, String department, String title,boolean pref,String type) /*-{
		var co = new $wnd.ContactOrganization();

		co.name = name;
		co.department = department;
		co.title = title;
        co.type = type;
        co.pref = pref;
		return co;

	}-*/;

	@Override
	public native ContactAddress createContactAddress(String type,boolean isPref, String streetAddress, String locality, String region, String postalCode, String country) /*-{
		var ca = new $wnd.ContactAddress();

		ca.streetAddress = streetAddress;
		ca.locality = locality;
		ca.region = region;
		ca.postalCode = postalCode;
		ca.country = country;
        ca.type = type;
        ca.pref = isPref;
        return ca;
	}-*/;

}
