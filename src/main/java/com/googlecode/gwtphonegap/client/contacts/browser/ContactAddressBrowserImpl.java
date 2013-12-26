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

public class ContactAddressBrowserImpl implements ContactAddress {

	private String formatted;
	private String streetAddress;
	private String locality;
	private String region;
	private String postalCode;
	private String country;
	private String type;
	private boolean pref;

	@Override
	public void setFormatted(String formatted) {
		this.formatted = formatted;

	}

	@Override
	public String getFormatted() {
		return formatted;
	}

	@Override
	public void setStreetAddress(String address) {
		this.streetAddress = address;

	}

	@Override
	public String getStreetAddress() {
		return streetAddress;
	}

	@Override
	public void setLocality(String locality) {
		this.locality = locality;

	}

	@Override
	public String getLocality() {
		return locality;
	}

	@Override
	public void setRegion(String region) {
		this.region = region;

	}

	@Override
	public String getRegion() {
		return region;
	}

	@Override
	public void setPostalCode(String code) {
		this.postalCode = code;

	}

	@Override
	public String getPostalCode() {
		return this.postalCode;
	}

	@Override
	public void setCountry(String country) {
		this.country = country;

	}

	@Override
	public String getCountry() {
		return country;
	}

	@Override
	public void setPref(boolean pref) {
		this.pref = pref;
	}

	@Override
	public boolean isPref() {
		return pref;
	}

	@Override
	public void setType(String type) {
		this.type = type;

	}

	@Override
	public String getType() {
		return type;
	}

}
