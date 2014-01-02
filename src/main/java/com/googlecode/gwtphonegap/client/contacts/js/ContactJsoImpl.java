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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.googlecode.gwtphonegap.client.contacts.Contact;
import com.googlecode.gwtphonegap.client.contacts.ContactAddress;
import com.googlecode.gwtphonegap.client.contacts.ContactField;
import com.googlecode.gwtphonegap.client.contacts.ContactName;
import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;
import com.googlecode.gwtphonegap.collection.client.JsLightArray;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

public final class ContactJsoImpl extends JavaScriptObject implements Contact {

	protected ContactJsoImpl() {

	}

	@Override
	public native String getId() /*-{
		return this.id;
	}-*/;

	@Override
	public native void setDisplayName(String displayName) /*-{
		this.displayName = displayName;
	}-*/;

	@Override
	public native String getDisplayName() /*-{
		return this.displayName;
	}-*/;

	@Override
	public native void setName(ContactName contactName) /*-{
		this.name = contactName;
	}-*/;

	@Override
	public native ContactName getName() /*-{
		if (this.name == null) {
			this.name = new $wnd.ContactName();
		}
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
		if (this.phoneNumbers == null) {
			this.phoneNumbers = [];
		}
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
		if (this.emails == null) {
			this.emails = [];
		}
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
		if (!(contactAddresses instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) contactAddresses;
		setContactAddressesJso(jsLightArray.getArray());

	}

	private native void setContactAddressesJso(JavaScriptObject obj)/*-{
		this.addresses = obj;
	}-*/;

	private native JsArray<ContactAddressJsoImpl> getContactAddressesJso()/*-{
		if (this.addresses == null) {
			this.addresses = [];
		}
		return this.addresses;
	}-*/;

	@Override
	public LightArray<ContactAddress> getContactAddresses() {
		JsArray<ContactAddressJsoImpl> contactAddressesJso = getContactAddressesJso();
		return new JsLightArray<ContactAddress>(contactAddressesJso);
	}

	private native void setImsJso(JavaScriptObject obj)/*-{
		this.ims = obj;
	}-*/;

	@Override
	public void setIms(LightArray<ContactField> ims) {
		if (!(ims instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) ims;
		setImsJso(jsLightArray.getArray());
	}

	private native JsArray<ContactFieldJsoImpl> getImsJso()/*-{
		if (this.ims == null) {
			this.ims = [];
		}
		return this.ims;
	}-*/;

	@Override
	public LightArray<ContactField> getIms() {
		JsArray<ContactFieldJsoImpl> imsJso = getImsJso();
		return new JsLightArray<ContactField>(imsJso);
	}

	private native void setOrganisationsJso(JavaScriptObject obj)/*-{
		this.organizations = obj;
	}-*/;

	@Override
	public void setOrganisations(LightArray<ContactOrganisation> organisations) {
		if (!(organisations instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) organisations;
		setOrganisationsJso(jsLightArray.getArray());

	}

	private native JsArray<ContactOrganisationJsoImpl> getOrganisationsJso()/*-{
		if (this.organizations == null) {
			this.organizations = [];
		}
		return this.organizations;
	}-*/;

	@Override
	public LightArray<ContactOrganisation> getOrganisations() {
		JsArray<ContactOrganisationJsoImpl> organisationsJso = getOrganisationsJso();
		return new JsLightArray<ContactOrganisation>(organisationsJso);
	}


	@Override
	public native Date getBirthDay() /*-{
		var time = this.birthday.getTime();
		return @com.googlecode.gwtphonegap.client.contacts.js.ContactJsoImpl::createDate(D)(time);
	}-*/;

	@Override
	public void setBirthDay(Date birthday) {
		setBirthDayJso(birthday.getTime());

	}

	private native void setBirthDayJso(double time)/*-{
		this.birthday = new Date(time);
	}-*/;
        
	@Override
	public native void setNote(String note) /*-{
		this.note = note;
	}-*/;

	@Override
	public native String getNote() /*-{
		return this.note;
	}-*/;

	private native void setPhotosJso(JavaScriptObject obj)/*-{
		this.photos = obj;
	}-*/;

	@Override
	public void setPhotos(LightArray<ContactField> photos) {
		if (!(photos instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) photos;
		setPhotosJso(jsLightArray.getArray());

	}

	private native JsArray<ContactFieldJsoImpl> getPhotosJso()/*-{
		if (this.photos == null) {
			this.photos = [];
		}
		return this.photos;
	}-*/;

	@Override
	public LightArray<ContactField> getPhotos() {
		JsArray<ContactFieldJsoImpl> photosJso = getPhotosJso();
		return new JsLightArray<ContactField>(photosJso);
	}

	private native void setCategoriesJso(JavaScriptObject obj)/*-{
		this.categories = obj;
	}-*/;

	@Override
	public void setCategories(LightArray<ContactField> categories) {
		if (!(categories instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) categories;
		setCategoriesJso(jsLightArray.getArray());

	}

	private native JsArray<ContactFieldJsoImpl> getCategoriesJso()/*-{
		if (this.categories == null) {
			this.categories = [];
		}
		return this.categories;
	}-*/;

	@Override
	public LightArray<ContactField> getCategories() {
		JsArray<ContactFieldJsoImpl> categoriesJso = getCategoriesJso();
		return new JsLightArray<ContactField>(categoriesJso);
	}

	private native void setUrlsJso(JavaScriptObject obj)/*-{
		this.urls = obj;
	}-*/;

	@Override
	public void setUrls(LightArray<ContactField> urls) {
		if (!(urls instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) urls;
		setUrlsJso(jsLightArray.getArray());

	}

	private native JsArray<ContactFieldJsoImpl> getUrlsJso()/*-{
		if (this.urls == null) {
			this.urls = [];
		}
		return this.urls;
	}-*/;

	@Override
	public LightArray<ContactField> getUrls() {
		JsArray<ContactFieldJsoImpl> urlsJso = getUrlsJso();
		return new JsLightArray<ContactField>(urlsJso);
	}

	@Override
	public native void remove() /*-{
		this.remove();
	}-*/;

	@Override
	public native void save() /*-{
		this.save();
	}-*/;

        @Override
	public native Contact cloneContact()/*-{
		return this.clone();
	}-*/;

}
