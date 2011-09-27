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
package com.googlecode.gwtphonegap.client.contacts;

import java.util.Date;

import de.kurka.gwt.collection.shared.LightArray;

/**
 * Contains properties that describe a contact, such as a user's personal or
 * business contact.
 * 
 * @author Daniel Kurka
 * 
 */
public interface Contact {

	/**
	 * globally unique identifier. (DOMString)
	 * 
	 * @return globally unique identifier. (DOMString)
	 */
	public String getId();

	/**
	 * Set the name of this Contact, suitable for display to end-users.
	 * (DOMString)
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName);

	/**
	 * The name of this Contact, suitable for display to end-users. (DOMString)
	 * 
	 * @return
	 */
	public String getDisplayName();

	/**
	 * set the object containing all components of a persons name
	 * 
	 * @param contactName
	 */
	public void setName(ContactName contactName);

	/**
	 * An object containing all components of a persons name
	 * 
	 * @return
	 */
	public ContactName getName();

	/**
	 * A casual name to address the contact by. (DOMString)
	 * 
	 * @param name
	 */
	public void setNickName(String name);

	/**
	 * A casual name to address the contact by. (DOMString)
	 * 
	 * @return
	 */
	public String getNickName();

	/**
	 * An array of all the contact's phone numbers. (ContactField[])
	 * 
	 * @return
	 */
	public LightArray<ContactField> getPhoneNumbers();

	/**
	 * An array of all the contact's phone numbers. (ContactField[])
	 * 
	 * @param array
	 */
	public void setPhoneNumbers(LightArray<ContactField> array);

	/**
	 * An array of all the contact's email addresses. (ContactField[])
	 * 
	 * @param emails
	 */
	public void setEmails(LightArray<ContactField> emails);

	/**
	 * An array of all the contact's email addresses. (ContactField[])
	 * 
	 * @return
	 */
	public LightArray<ContactField> getEmails();

	/**
	 * An array of all the contact's addresses. (ContactAddresses[])
	 * 
	 * @param contactAddresses
	 */
	public void setContactAddresses(LightArray<ContactAddress> contactAddresses);

	/**
	 * An array of all the contact's addresses. (ContactAddresses[])
	 * 
	 * @return
	 */
	public LightArray<ContactAddress> getContactAddresses();

	/**
	 * An array of all the contact's IM addresses. (ContactField[])
	 * 
	 * @param ims
	 */
	public void setIms(LightArray<ContactField> ims);

	/**
	 * An array of all the contact's IM addresses. (ContactField[])
	 * 
	 * @return
	 */
	public LightArray<ContactField> getIms();

	/**
	 * An array of all the contact's organizations. (ContactOrganization[])
	 * 
	 * @param organisations
	 */
	public void setOrganisations(LightArray<ContactOrganisation> organisations);

	/**
	 * An array of all the contact's organizations. (ContactOrganization[])
	 * 
	 * @return
	 */
	public LightArray<ContactOrganisation> getOrganisations();

	/**
	 * he last date the contact was revised. (DOMString)
	 * 
	 * @return
	 */
	public String getRevision();

	/**
	 * The birthday of the contact. (Date)
	 * 
	 * @return
	 */
	public Date getBirthDay();

	/**
	 * The birthday of the contact. (Date)
	 * 
	 * @param birthday
	 */
	public void setBirthDay(Date birthday);

	/**
	 * The gender of the contact. (DOMString)
	 * 
	 * @param gender
	 */
	public void setGender(String gender);

	/**
	 * The gender of the contact. (DOMString)
	 * 
	 * @return
	 */
	public String getGender();

	/**
	 * A note about the contact. (DOMString)
	 * 
	 * @param note
	 */
	public void setNote(String note);

	/**
	 * A note about the contact. (DOMString)
	 * 
	 * @return
	 */
	public String getNote();

	/**
	 * An array of the contact's photos. (ContactField[])
	 * 
	 * @param photos
	 */
	public void setPhotos(LightArray<ContactField> photos);

	/**
	 * An array of the contact's photos. (ContactField[])
	 * 
	 * @return
	 */
	public LightArray<ContactField> getPhotos();

	/**
	 * An array of all the contacts user defined categories. (ContactField[])
	 * 
	 * @param categories
	 */
	public void setCategories(LightArray<ContactField> categories);

	/**
	 * An array of all the contacts user defined categories. (ContactField[])
	 * 
	 * @return
	 */
	public LightArray<ContactField> getCategories();

	/**
	 * An array of web pages associated to the contact. (ContactField[])
	 * 
	 * @param urls
	 */
	public void setUrls(LightArray<ContactField> urls);

	/**
	 * An array of web pages associated to the contact. (ContactField[])
	 * 
	 * @return
	 */
	public LightArray<ContactField> getUrls();

	/**
	 * The timezone of the conact. (DOMString)
	 * 
	 * @param zone
	 */
	public void setTimeZone(String zone);

	/**
	 * The timezone of the conact. (DOMString)
	 * 
	 * @return
	 */
	public String getTimeZone();

	/**
	 * 
	 * @return a new Contact object that is a deep copy of the calling object,
	 *         with the id property set to null.
	 */
	public Contact clone();

	/**
	 * Removes the contact from the device contacts database. An error callback
	 * is called with a ContactError object if the removal is unsuccessful.
	 */
	public void remove();

	/**
	 * Saves a new contact to the device contacts database, or updates an
	 * existing contact if a contact with the same id already exists.
	 */
	public void save();
}
