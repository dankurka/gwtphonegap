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

import java.util.Set;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.storage.client.Storage;
import com.googlecode.gwtphonegap.client.contacts.Contact;
import com.googlecode.gwtphonegap.client.contacts.ContactFactory;
import com.googlecode.gwtphonegap.client.contacts.ContactFindCallback;
import com.googlecode.gwtphonegap.client.contacts.ContactFindOptions;
import com.googlecode.gwtphonegap.client.contacts.Contacts;
import com.googlecode.gwtphonegap.client.device.DeviceBrowserImpl;
import com.googlecode.gwtphonegap.collection.shared.CollectionFactory;
import com.googlecode.gwtphonegap.collection.shared.LightArray;
import com.googlecode.gwtphonegap.collection.shared.LightMap;

public class ContactsBrowserImpl implements Contacts {

	private Storage storage;
	private ContactFactoryBrowserImpl contactFactory;

	public ContactsBrowserImpl() {
		storage = Storage.getLocalStorageIfSupported();
		if (storage == null) {
			throw new IllegalStateException("browser does not have local storage, but we need it for contacts emulation");
		}
	}

	@Override
	public Contact create() {
		return new ContactBrowserImpl(this);
	}

	@Override
	public void find(LightArray<String> fields, ContactFindCallback callback, ContactFindOptions contactFindOptions) {
		LightMap<Contact> fromStorage = loadContactsFromStorage();

		if (fields.length() == 0) {
			callback.onSuccess(toArray(fromStorage));
		}

		LightMap<Contact> result = CollectionFactory.constructMap();

		LightArray<String> keys = fromStorage.getKeys();

		String filter = contactFindOptions.getFilter();

		for (int i = 0; i < keys.length(); i++) {
			Contact contact = fromStorage.get(keys.get(i));

			for (int j = 0; j < fields.length(); j++) {
				String string = fields.get(j);

				if ("name".equals(string)) {
					if (contact.getName().getFamilyName() != null && contact.getName().getFamilyName().contains(filter)) {
						result.put(contact.getId(), contact);
						break;
					}
					if (contact.getName().getFamilyName() != null && contact.getName().getGivenName().contains(filter)) {
						result.put(contact.getId(), contact);
						break;
					}

				} else {
					// TODO implement the rest
				}

			}

		}

		callback.onSuccess(toArray(result));

	}

	private LightArray<Contact> toArray(LightMap<Contact> map) {
		LightArray<Contact> array = CollectionFactory.constructArray();

		LightArray<String> keys = map.getKeys();

		for (int i = 0; i < keys.length(); i++) {
			Contact contact = map.get(keys.get(i));
			array.set(i, contact);
		}

		return array;
	}

	@Override
	public ContactFactory getFactory() {
		if (contactFactory == null) {
			contactFactory = new ContactFactoryBrowserImpl();
		}
		return contactFactory;
	}

	public void remove(ContactBrowserImpl contactBrowserImpl) {

	}

	public void save(ContactBrowserImpl contactBrowserImpl) {
		LightMap<Contact> fromStorage = loadContactsFromStorage();

		// ensure id
		if (contactBrowserImpl.getId() == null || "".equals(contactBrowserImpl.getId())) {
			contactBrowserImpl.setId(DeviceBrowserImpl.getPseudoGUUID());
		}
		fromStorage.put(contactBrowserImpl.getId(), contactBrowserImpl);

		store(fromStorage);
	}

	private void store(LightMap<Contact> fromStorage) {
		JSONObject map = new JSONObject();
		LightArray<String> keys = fromStorage.getKeys();

		for (int i = 0; i < keys.length(); i++) {
			Contact contact = fromStorage.get(keys.get(i));
			JSONObject jsonContact = ((ContactBrowserImpl) contact).serializeContact();
			map.put(contact.getId(), jsonContact);
		}

		storage.setItem("gwtphonegap-contact-emulation", map.toString());
	}

	public Contact cloneContact(ContactBrowserImpl toClone) {
		ContactBrowserImpl contact = new ContactBrowserImpl(this);

		contact.setBirthDay(toClone.getBirthDay());
		contact.setCategories(toClone.getCategories());
		contact.setContactAddresses(toClone.getContactAddresses());
		contact.setDisplayName(toClone.getDisplayName());
		contact.setEmails(toClone.getEmails());
		contact.setGender(toClone.getGender());
		contact.setIms(toClone.getIms());
		contact.setName(toClone.getName());
		contact.setNickName(toClone.getNickName());
		contact.setNote(toClone.getNote());
		contact.setOrganisations(toClone.getOrganisations());
		contact.setPhoneNumbers(toClone.getPhoneNumbers());
		contact.setPhotos(toClone.getPhotos());
		contact.setRevision(toClone.getRevision());
		contact.setTimeZone(toClone.getTimeZone());
		contact.setUrls(toClone.getUrls());

		return contact;
	}

	protected LightMap<Contact> loadContactsFromStorage() {
		LightMap<Contact> map = CollectionFactory.constructMap();

		String item = storage.getItem("gwtphonegap-contact-emulation");
		if (item == null) {
			return map;
		}
		JSONValue parsed = JSONParser.parseStrict(item);

		JSONObject root = parsed.isObject();
		if (root == null) {
			return map;
		} else {
			Set<String> set = root.keySet();
			for (String key : set) {
				JSONObject jsonContact = root.get(key).isObject();
				Contact contact = parseContact(jsonContact);
				map.put(contact.getId(), contact);
			}
		}

		return map;
	}

	private Contact parseContact(JSONObject jsonContact) {
		if (jsonContact == null) {
			throw new IllegalStateException();
		}

		Contact contact = ContactBrowserImpl.fromJSON(this, jsonContact);
		return contact;
	}

}
