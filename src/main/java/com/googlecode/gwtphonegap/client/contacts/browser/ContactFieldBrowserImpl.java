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

import com.googlecode.gwtphonegap.client.contacts.ContactField;

public class ContactFieldBrowserImpl implements ContactField {

	private String type;
	private String value;
	private boolean pref;

	@Override
	public void setType(String type) {
		this.type = type;

	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setValue(String value) {
		this.value = value;

	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setPref(boolean pref) {
		this.pref = pref;

	}

	@Override
	public boolean isPref() {
		return pref;
	}

}
