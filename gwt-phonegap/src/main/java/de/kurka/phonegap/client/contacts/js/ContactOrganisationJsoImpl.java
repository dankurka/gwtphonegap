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

import de.kurka.phonegap.client.contacts.ContactOrganisation;

public final class ContactOrganisationJsoImpl extends JavaScriptObject implements ContactOrganisation {

	protected ContactOrganisationJsoImpl() {

	}

	@Override
	public native void setName(String name) /*-{
		this.name = name;
	}-*/;

	@Override
	public native String getName() /*-{
		return this.name;
	}-*/;

	@Override
	public native void setDepartment(String department) /*-{
		this.department = department;
	}-*/;

	@Override
	public native String getDepartment() /*-{
		return this.department;
	}-*/;

	@Override
	public native void setTitle(String title) /*-{
		return this.title;
	}-*/;

	@Override
	public native String getTitle() /*-{
		return this.title;
	}-*/;

}
