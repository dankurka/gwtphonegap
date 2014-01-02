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
import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;


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
		 this.title = title;
	}-*/;

	@Override
	public native String getTitle() /*-{
		return this.title;
	}-*/;

        /**
         * Set to true if this ContactOrganization contains the user's 
         * preferred value. (boolean)
         *
         * @param pref
         */
        @Override
        public native void setPref(boolean pref) /*-{
                this.pref = pref;
        }-*/;

        /**
         * Set to true if this ContactOrganization contains the user's 
         * preferred value. (boolean)
         *
         * @return
         */
        @Override
        public native boolean isPref() /*-{
                return this.pref;
        }-*/;

        /**
         * The department the contact works for. (DOMString)
         *
         * @param type
         */
        @Override
        public native void setType(String type) /*-{
                this.type = type;
        }-*/;

        /**
         * The department the contact works for. (DOMString)
         *
         * @return
         */
        @Override
        public native String getType()/*-{
                return this.type;
        }-*/;

}
