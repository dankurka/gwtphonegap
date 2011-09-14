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
import com.google.gwt.core.client.JsDate;

import de.kurka.gwt.collection.client.JsLightArray;
import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.contacts.Contact;
import de.kurka.phonegap.client.contacts.ContactFactory;
import de.kurka.phonegap.client.contacts.ContactFindCallback;
import de.kurka.phonegap.client.contacts.ContactFindOptions;
import de.kurka.phonegap.client.contacts.Contacts;

public class ContactsJsoImpl implements Contacts {

	@Override
	public native Contact create() /*-{
		return $wnd.navigator.contacts.create();
	}-*/;

	@Override
	public void find(LightArray<String> fields, ContactFindCallback callback, ContactFindOptions contactFindOptions) {
		if (!(fields instanceof JsLightArray<?>)) {
			throw new IllegalArgumentException();
		}
		JsLightArray<?> jsLightArray = (JsLightArray<?>) fields;
		JavaScriptObject jsFields = jsLightArray.getArray();
		findNative(jsFields, callback, contactFindOptions);
	}

	private void callSuccess(ContactFindCallback callback, JavaScriptObject contacts) {
		JsLightArray<Contact> jsLightArray = new JsLightArray<Contact>(contacts);
		callback.onSuccess(jsLightArray);
	}

	public native void findNative(JavaScriptObject fields, ContactFindCallback callback, ContactFindOptions contactFindOptions) /*-{
		var instance = this;

		var sC = function(contacts) {
			instance.@de.kurka.phonegap.client.contacts.js.ContactsJsoImpl::callSuccess(Lde/kurka/phonegap/client/contacts/ContactFindCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, contacts);
		};

		var eC = function(error) {
			callback.@de.kurka.phonegap.client.contacts.ContactFindCallback::onFailure(Lde/kurka/phonegap/client/contacts/ContactError;)(error);
		};

		var lfilter = contactFindOptions.@de.kurka.phonegap.client.contacts.ContactFindOptions::getFilter()();
		var lmultiple = contactFindOptions.@de.kurka.phonegap.client.contacts.ContactFindOptions::isMutiple()();
		var gwtDate = contactFindOptions.@de.kurka.phonegap.client.contacts.ContactFindOptions::getUpdatedSince()();
		var ldate = "";
		if (gwtDate != null) {
			ldate = this.@de.kurka.phonegap.client.contacts.js.ContactsJsoImpl::createJsDate(Ljava/util/Date;)(gwtDate);
		}

		var options = {
			filter : lfilter,
			multiple : lmultiple,
			updatedSince : ldate
		};

		$wnd.navigator.contacts.find(fields, $entry(sC), $entry(eC), options);
	}-*/;

	private JsDate createJsDate(Date date) {
		return JsDate.create(date.getTime());
	}

	@Override
	public ContactFactory getFacotry() {
		return new ContactFactoryJsoImpl();
	}

}
