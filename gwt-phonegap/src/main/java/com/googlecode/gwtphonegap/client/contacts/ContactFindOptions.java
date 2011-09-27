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

import java.util.Date;

public class ContactFindOptions {
	private String filter;
	private boolean mutiple;
	private Date updatedSince;

	public ContactFindOptions() {
		this("");
	}

	public ContactFindOptions(String filter) {
		this(filter, true);
	}

	public ContactFindOptions(String filter, boolean mutiple) {
		this(filter, mutiple, null);
	}

	public ContactFindOptions(String filter, boolean mutiple, Date updatedSince) {
		this.filter = filter;
		this.mutiple = mutiple;
		this.updatedSince = updatedSince;

	}

	public Date getUpdatedSince() {
		return updatedSince;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public void setUpdatedSince(Date updatedSince) {
		this.updatedSince = updatedSince;
	}

	public void setMutiple(boolean mutiple) {
		this.mutiple = mutiple;
	}

	public String getFilter() {
		return filter;
	}

	public boolean isMutiple() {
		return mutiple;
	}

}
