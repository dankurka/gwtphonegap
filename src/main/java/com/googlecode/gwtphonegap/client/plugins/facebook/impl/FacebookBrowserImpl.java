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
package com.googlecode.gwtphonegap.client.plugins.facebook.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.gwtphonegap.client.plugins.facebook.Facebook;
import com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback;
import com.googlecode.gwtphonegap.client.plugins.facebook.callback.LoginStatusCallback;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthEvent;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthEvent.AuthEventType;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthHandler;
import com.googlecode.gwtphonegap.client.plugins.facebook.jsni.LoginStatus;

import java.util.Map;

/**
 * Empty implementation for browser mock
 *
 * @author Ronny Bubke
 */
public class FacebookBrowserImpl implements Facebook {

	private EventBus handlerManager;
	private boolean initialized;
	private boolean loggedIn;
	private boolean hasHandlers;

	public FacebookBrowserImpl() {
		handlerManager = new SimpleEventBus();
	}

	@Override
	public void initialize() {
		initialized = true;
	}

	@Override
	public HandlerRegistration addAuthHandler(AuthHandler handler) {
		ensureInitialized();
		hasHandlers = true;
		return handlerManager.addHandler(AuthEvent.getType(), handler);
	}

	@Override
	public void initialize(Map<String, Object> options) {
		initialize();
	}

	@Override
	public void getLoginStatus(LoginStatusCallback callback, boolean force) {
		ensureInitialized();
		callback.onResponse(createLoginStatusMock());
	}

	@Override
	public void login(Map<String, Object> options, LoginStatusCallback callback) {
		ensureInitialized();
		loggedIn = true;
		if (callback != null)
			callback.onResponse(createLoginStatusMock());
	}

	@Override
	public void logout() {
		ensureInitialized();
		loggedIn = false;
		handlerManager.fireEvent(new AuthEvent(AuthEventType.LOGOUT,
				createLoginStatusMock()));
	}

	@Override
	public <T extends JavaScriptObject> void api(String path,
												 Map<String, String> options, GenericCallback<T> callback) {
		ensureInitialized();
		callback.onResponse((T) createApiResponseMock());
	}

	@Override
	public <T extends JavaScriptObject> void ui(String method,
												Map<String, String> options, GenericCallback<T> callback) {
		ensureInitialized();
		// do nothing - can be everything
	}

	@Override
	public void setEventBus(EventBus eventBus) {
		assert !hasHandlers : "The handlerManager can not be replaced because it has got handlers";
		handlerManager = eventBus;
	}

	private native LoginStatus createLoginStatusMock()
	/*-{
        var loggedIn = this.@com.googlecode.gwtphonegap.client.plugins.facebook.impl.FacebookBrowserImpl::loggedIn;
        if (loggedIn) {
            return {
                authResponse: {
                    accessToken: "access.token.mock",
                    expiresIn: "123456",
                    userID: "user.mock",
                    expirationTime: 1844585290
                },
                status: "connected"
            };
        }
        return {
            authResponse: null,
            status: "notConnected"
        };
    }-*/;

	private native <T> T createApiResponseMock()
	/*-{
        return {
            id: "user_id_mock",
            first_name: "firstname.mock",
            last_name: "lastname.mock",
            link: "http://facebook.com/user_id_mock",
            username: "username.mock",
            gender: "male",
            locale: "de",
            updated_time: "2013-01-20T07:43:24+0000"
        };
    }-*/;

	private void ensureInitialized() {
		if (!initialized) {
			throw new IllegalStateException(
					"you have to initialize Facebook Plugin before using it");
		}
	}
}
