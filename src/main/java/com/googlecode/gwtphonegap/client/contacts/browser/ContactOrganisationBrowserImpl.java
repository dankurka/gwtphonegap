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

import com.googlecode.gwtphonegap.client.contacts.ContactOrganisation;

public class ContactOrganisationBrowserImpl implements ContactOrganisation {

	private String name;
	private String department;
	private String title;
    private String type;
    private boolean pref;

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setDepartment(String department) {
		this.department = department;

	}

	@Override
	public String getDepartment() {
		return department;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;

	}

	@Override
	public String getTitle() {
		return title;
	}

    /**
     * Set to true if this ContactOrganization contains the user's preferred value. (boolean)
     *
     * @param pref
     */
    @Override
    public void setPref(boolean pref) {
    this.pref = pref;
    }

    /**
     * Set to true if this ContactOrganization contains the user's preferred value. (boolean)
     *
     * @return
     */
    @Override
    public boolean isPref() {
        return pref;
    }

    /**
     * The department the contract works for. (DOMString)
     *
     * @param type
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The department the contract works for. (DOMString)
     *
     * @return
     */
    @Override
    public String getType() {
        return type;
    }

}
