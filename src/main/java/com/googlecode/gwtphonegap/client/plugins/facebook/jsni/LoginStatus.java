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

/**
 * @author Ronny Bubke
 * 
 */
public class LoginStatus extends JavaScriptObject {

	public enum LoginState {
		CONNECTED("connected"), NOTCONNECTED("notConnected"), UNKNOWN("unknown");

		private String statusString;

		private LoginState(String statusString) {
			this.statusString = statusString;
		}

		@Override
		public String toString() {
			return statusString;
		}

		public static LoginState fromString(String loginState) {
			for (LoginState state : values()) {
				if (state.statusString.equals(loginState)) {
					return state;
				}
			}
			return null;
		}
	}

	protected LoginStatus() {
	}

	public final native AuthResponse getAuthResponse()
	/*-{
		return this.authResponse;
	}-*/;

	public final LoginState getState() {
		return LoginState.fromString(getStatusNative());
	}

	private final native String getStatusNative()
	/*-{
		return this.status;
	}-*/;

}
