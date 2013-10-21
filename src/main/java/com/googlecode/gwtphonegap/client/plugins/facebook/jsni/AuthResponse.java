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
public class AuthResponse extends JavaScriptObject {

	protected AuthResponse() {

	}

	public final String getAccessToken() {
		return JSNIHelper.getPropertyValue(this, "accessToken");
	}

	public final String getExpiresIn() {
		return JSNIHelper.getPropertyValue(this, "expiresIn");
	}

	public final String getUserId() {
		String userId = JSNIHelper.getPropertyValue(this, "userID");
		if (userId == null) {
			/*
			 * This is a workaround due to a bug in phonegap facebook plugin.
			 * 2013/06/13
			 */
			userId = JSNIHelper.getPropertyValue(this, "userId");
		}
		return userId;
	}

	public final long getExpirationTimestamp() {
		String stringValue = JSNIHelper
				.getPropertyValue(this, "expirationTime");
		return Long.valueOf(stringValue);
	}
}
