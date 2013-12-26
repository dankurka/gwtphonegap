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

import com.googlecode.gwtphonegap.collection.shared.LightArray;

public interface Contacts {
	public Contact create();

	/**
	 * Queries the device contacts database and returns one or more Contact
	 * objects, each containing the fields specified.
	 * 
	 * contacts.find is an asynchronous function that queries the device
	 * contacts database and returns an array of Contact objects. The resulting
	 * objects are passed to the contactSuccess callback function specified by
	 * the contactSuccess parameter.
	 * 
	 * Users must specify the contact fields to be used as a search qualifier in
	 * the contactFields parameter. Only the fields specified in the
	 * contactFields parameter will be returned as properties of the Contact
	 * objects that are passed to the contactSuccess callback function. A
	 * zero-length contactFields parameter will result in an array of Contact
	 * objects with only the id property populated.
	 * 
	 * The contactFindOptions.filter string can be used as a search filter when
	 * querying the contacts database. If provided, a case-insensitive, partial
	 * value match is applied to each field specified in the contactFields
	 * parameter. If a match is found in a comparison with any of the specified
	 * fields, the contact is returned.
	 * 
	 * Parameters
	 * 
	 * contactFields: Contact fields to be used as search qualifier. Only these
	 * fields will have values in the resulting Contact objects. (DOMString[])
	 * [Required] contactSuccess: Success callback function that is invoked with
	 * the contacts returned from the contacts database. [Required]
	 * contactError: Error callback function. Invoked when error occurs.
	 * [Optional] contactFindOptions: Search options to filter contacts.
	 * [Optional]
	 * 
	 * @param fields
	 * @param callback
	 * @param contactFindOptions
	 */
	public void find(LightArray<String> fields, ContactFindCallback callback, ContactFindOptions contactFindOptions);

	public ContactFactory getFactory();

}
