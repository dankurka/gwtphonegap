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
package de.kurka.phonegap.client.contacts;

/**
 * Supports generic fields in a Contact object. Some properties that are stored
 * as ContactField objects include email addresses, phone numbers, and urls.
 * 
 * @author Daniel Kurka
 * 
 */
public interface ContactField {
	/**
	 * A string that tells you what type of field this is (example: 'home').
	 * (DOMString)
	 * 
	 * @param type
	 */
	public void setType(String type);

	/**
	 * A string that tells you what type of field this is (example: 'home').
	 * (DOMString)
	 * 
	 * @return
	 */
	public String getType();

	/**
	 * The value of the field (such as a phone number or email address).
	 * (DOMString)
	 * 
	 * @param value
	 */
	public void setValue(String value);

	/**
	 * The value of the field (such as a phone number or email address).
	 * (DOMString)
	 * 
	 * @return
	 */
	public String getValue();

	/**
	 * Set to true if this ContactField contains the user's preferred value.
	 * (boolean)
	 * 
	 * @param pref
	 */
	public void setPref(boolean pref);

	/**
	 * Set to true if this ContactField contains the user's preferred value.
	 * (boolean)
	 * 
	 * @return
	 */
	public boolean isPref();
}
