/*
 * Copyright 2013 Ronny Bubke
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
package com.googlecode.gwtphonegap.client.plugins.facebook.jsni;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.util.JSNIHelper;

/**
 * @author Ronny Bubke
 * 
 */
public final class ApiResponse extends JavaScriptObject {

	protected ApiResponse() {
	}

	public final String getId() {
		return JSNIHelper.getPropertyValue(this, "id");
	}

	public final String getFirstName() {
		return JSNIHelper.getPropertyValue(this, "first_name");
	}

	public final String getLastName() {
		return JSNIHelper.getPropertyValue(this, "last_name");
	}

	public final String getLink() {
		return JSNIHelper.getPropertyValue(this, "link");
	}

	public final String getPictureUrl() {
		return JSNIHelper.getPropertyValue(this, "picture.data.url");
	}

	public final String getUsername() {
		return JSNIHelper.getPropertyValue(this, "username");
	}

	public final String getGender() {
		return JSNIHelper.getPropertyValue(this, "gender");
	}

	public final String getLocale() {
		return JSNIHelper.getPropertyValue(this, "locale");
	}

	public final String getUpdatedTime() {
		return JSNIHelper.getPropertyValue(this, "updated_time");
	}

}
