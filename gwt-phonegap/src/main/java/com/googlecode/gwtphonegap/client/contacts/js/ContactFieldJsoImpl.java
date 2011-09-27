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

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.contacts.ContactField;


public final class ContactFieldJsoImpl extends JavaScriptObject implements ContactField {

	protected ContactFieldJsoImpl() {

	}

	@Override
	public native void setType(String type) /*-{
		this.type = type;
	}-*/;

	@Override
	public native String getType() /*-{
		return this.type;
	}-*/;

	@Override
	public native void setValue(String value) /*-{
		this.value = value;
	}-*/;

	@Override
	public native String getValue() /*-{
		return this.value;
	}-*/;

	@Override
	public native void setPref(boolean pref) /*-{
		this.pref = pref;
	}-*/;

	@Override
	public native boolean isPref() /*-{
		if (typeof (this.pref) == "undefined") {
			return false;
		}
		return this.pref;
	}-*/;

}
