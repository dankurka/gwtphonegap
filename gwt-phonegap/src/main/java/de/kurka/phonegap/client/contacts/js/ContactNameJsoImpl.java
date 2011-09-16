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

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.contacts.ContactName;

public final class ContactNameJsoImpl extends JavaScriptObject implements ContactName {

	protected ContactNameJsoImpl() {

	}

	@Override
	public native void setFormatted(String formatted) /*-{
		this.formatted = formatted;

	}-*/;

	@Override
	public native String getFormatted() /*-{
		return this.formatted;
	}-*/;

	@Override
	public native void setFamilyName(String name) /*-{
		this.familyName = name;

	}-*/;

	@Override
	public native String getFamilyName() /*-{
		return this.familyName;
	}-*/;

	@Override
	public native void setGivenName(String name) /*-{
		this.givenName = name;

	}-*/;

	@Override
	public native String getGivenName() /*-{
		return this.givenName;
	}-*/;

	@Override
	public native void setMiddleName(String name) /*-{
		this.middleName = name;

	}-*/;

	@Override
	public native String getMiddleName() /*-{
		return this.middleName;
	}-*/;

	@Override
	public native void setHonoricfPrefix(String prefix) /*-{
		this.honorificPrefix = prefix;

	}-*/;

	@Override
	public native String getHonoricPrefix() /*-{
		return this.honorificPrefix;
	}-*/;

	@Override
	public native void setHonoricfSuffix(String suffix) /*-{
		this.honorificSuffix = suffix;

	}-*/;

	@Override
	public native String getHonoricSuffix() /*-{
		return this.honorificSuffix;
	}-*/;

}
