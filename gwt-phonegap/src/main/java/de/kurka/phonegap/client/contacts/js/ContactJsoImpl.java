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
package de.kurka.phonegap.client.contacts.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.kurka.gwt.collection.client.JsLightArray;
import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.contacts.Contact;
import de.kurka.phonegap.client.contacts.ContactAddress;
import de.kurka.phonegap.client.contacts.ContactField;
import de.kurka.phonegap.client.contacts.ContactName;
import de.kurka.phonegap.client.contacts.ContactOrganisation;

public final class ContactJsoImpl extends JavaScriptObject implements Contact {

	protected ContactJsoImpl() {

	}

	@Override
	public native String getId() /*-{
		return this.id;
	}-*/;

	@Override
	public native void setDisplayName(String displayName) /*-{
		this.displayname = displayName;
	}-*/;

	@Override
	public native String getDisplayName() /*-{
		return this.displayname;
	}-*/;

	@Override
	public native void setName(ContactName contactName) /*-{
		this.name = contactName;
	}-*/;

	@Override
	public native ContactName getName() /*-{
		return this.name;
	}-*/;

	@Override
	public native void setNickName(String name) /*-{
		this.nickname = name;
	}-*/;

	@Override
	public native String getNickName() /*-{
		return this.nickname;
	}-*/;

	private native JsArray<ContactFieldJsoImpl> getPhoneNumbersJSO()/*-{
		return this.phoneNumbers;
	}-*/;

	@Override
	public LightArray<ContactField> getPhoneNumbers() {
		JsArray<ContactFieldJsoImpl> numbersJSO = getPhoneNumbersJSO();
		return new JsLightArray<ContactField>(numbersJSO);
	}

	@Override
	public void setPhoneNumbers(LightArray<ContactField> array) {
		if (!(array instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) array;
		setPhoneNumebersJso(jsLightArray.getArray());
	}

	private native void setPhoneNumebersJso(JavaScriptObject array)/*-{
		this.phoneNumbers = array;
	}-*/;

	@Override
	public void setEmails(LightArray<ContactField> emails) {
		if (!(emails instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) emails;
		setEmailsJso(jsLightArray.getArray());

	}

	private native JsArray<ContactFieldJsoImpl> getEmailsJso()/*-{
		return this.emails;
	}-*/;

	@Override
	public LightArray<ContactField> getEmails() {
		return new JsLightArray<ContactField>(getEmailsJso());
	}

	private native void setEmailsJso(JavaScriptObject object)/*-{
		this.emails = object;
	}-*/;

	@Override
	public void setContactAddresses(LightArray<ContactAddress> contactAddresses) {
		// TODO

	}

	@Override
	public LightArray<ContactAddress> getContactAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIms(LightArray<ContactField> ims) {
		// TODO Auto-generated method stub

	}

	@Override
	public LightArray<ContactField> getIms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrganisations(LightArray<ContactOrganisation> organisations) {
		// TODO Auto-generated method stub

	}

	@Override
	public LightArray<ContactOrganisation> getOrganisations() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRevision() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getBirthDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBirthDay(Date birthday) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNote(String note) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getNote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPhotos(LightArray<ContactField> photos) {
		// TODO Auto-generated method stub

	}

	@Override
	public LightArray<ContactField> getPhotos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCategories(LightArray<ContactField> categories) {
		// TODO Auto-generated method stub

	}

	@Override
	public LightArray<ContactField> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUrls(LightArray<ContactField> urls) {
		// TODO Auto-generated method stub

	}

	@Override
	public LightArray<ContactField> getUrls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTimeZone(String zone) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	public native Contact clone()/*-{
		return this.clone();
	}-*/;

}
