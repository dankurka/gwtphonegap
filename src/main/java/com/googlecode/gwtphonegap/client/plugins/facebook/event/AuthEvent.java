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
package com.googlecode.gwtphonegap.client.plugins.facebook.event;

import com.google.gwt.event.shared.GwtEvent;
import com.googlecode.gwtphonegap.client.plugins.facebook.jsni.LoginStatus;

public class AuthEvent extends GwtEvent<AuthHandler> {

	public enum AuthEventType {
		LOGIN, LOGOUT, RESPONSE_CHANGE, STATUS_CHANGE;
	}

	private static final GwtEvent.Type<AuthHandler> TYPE = new Type<AuthHandler>();
	private final AuthEventType eventType;
	private final LoginStatus loginStatus;

	public AuthEvent(AuthEventType eventType, LoginStatus loginStatus) {
		this.eventType = eventType;
		this.loginStatus = loginStatus;
	}

	public static GwtEvent.Type<AuthHandler> getType() {
		return TYPE;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AuthHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AuthHandler handler) {
		switch (eventType) {
		case LOGIN:
			handler.onLogin(this);
			break;
		case LOGOUT:
			handler.onLogout(this);
			break;
		case RESPONSE_CHANGE:
			handler.onResponseChange(this);
			break;
		case STATUS_CHANGE:
			handler.onStatusChange(this);
			break;
		}
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}

}