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

public class ContactFindOptions {
	private String filter;
	private boolean multiple;

	public ContactFindOptions() {
		this("");
	}

	public ContactFindOptions(String filter) {
		this(filter, true);
	}

	public ContactFindOptions(String filter, boolean multiple) {
		this.filter = filter;
                this.multiple = multiple;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void setMultiple(boolean multiple) {
		this.multiple = multiple;
	}

	public String getFilter() {
		return filter;
	}

	public boolean isMultiple() {
		return multiple;
	}

}
