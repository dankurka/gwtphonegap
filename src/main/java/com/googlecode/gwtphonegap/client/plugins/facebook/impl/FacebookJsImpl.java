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

import com.google.common.collect.Maps;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerManager;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.gwtphonegap.client.plugins.facebook.Facebook;
import com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback;
import com.googlecode.gwtphonegap.client.plugins.facebook.callback.LoginStatusCallback;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthEvent;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthEvent.AuthEventType;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthHandler;
import com.googlecode.gwtphonegap.client.plugins.facebook.jsni.LoginStatus;
import com.googlecode.gwtphonegap.client.util.JSNIHelper;

import java.util.Map;

/**
 * Native javascript wrapper to access Facebook plugin javascript
 * implementation.
 * <p/>
 * https://github.com/phonegap/phonegap-facebook-plugin
 *
 * @author Ronny Bubke
 */
public class FacebookJsImpl implements Facebook {

	private boolean initialized;
	private HandlerManager handlerManager;

	public FacebookJsImpl() {
	}

	@Override
	public HandlerRegistration addAuthHandler(AuthHandler handler) {
		ensureInitialized();
		ensureHandlers();
		return handlerManager.addHandler(AuthEvent.getType(), handler);
	}

	/*
	 * This checks if the Facebook javascript library is installed.
	 *
	 * @see
	 * com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin#initialize()
	 */
	@Override
	public void initialize(Map<String, Object> options) {
		initialize();
		if (options == null) {
			options = Maps.newHashMap();
		}
		initializeNative(JSNIHelper.createObject(options));
	}

	@Override
	public void getLoginStatus(LoginStatusCallback callback) {
		ensureInitialized();
		getLoginStatusNative(callback);
	}

	/*
	 * Login into facebook. State is handled by native javascript
	 * implementation.
	 *
	 * @see com.googlecode.gwtphonegap.client.plugins.facebook.Facebook
	 * #login(java.lang.Iterable, java.lang.String,
	 * com.googlecode.gwtphonegap.client
	 * .plugins.facebook.Facebook.LoginCallback)
	 */
	@Override
	public void login(Map<String, Object> options, LoginStatusCallback callback) {
		ensureInitialized();
		ensureScope(options);
		loginNative(JSNIHelper.createObject(options), callback);
	}

	/*
	 * Logout from facebook.
	 *
	 * @see com.googlecode.gwtphonegap.client.plugins.facebook.Facebook
	 * #logout(com.googlecode.gwtphonegap.client.plugins.facebook.
	 * Facebook.LogoutCallback)
	 */
	@Override
	public void logout() {
		ensureInitialized();
		logoutNative();
	}

	/*
	 * Request data by using Facebook's graph path API.
	 *
	 * @see com.googlecode.gwtphonegap.client.plugins.facebook.Facebook
	 * #requestWithGraphPath(java.lang.String, java.util.Map, java.lang.String,
	 * com .googlecode.gwtphonegap.client.plugins.facebook.Facebook.
	 * RequestWithGraphPathCallback)
	 */
	@Override
	public <T extends JavaScriptObject> void api(String path, Map<String, String> options, GenericCallback<T> callback) {
		ensureInitialized();
		apiNative(path, JSNIHelper.createObject(options), callback);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.googlecode.gwtphonegap.client.plugins.facebook.Facebook#ui(java.lang
	 * .String, java.util.Map,
	 * com.googlecode.gwtphonegap.client.plugins.facebook.Facebook.UiCallback)
	 */
	@Override
	public <T extends JavaScriptObject> void ui(String method, Map<String, String> options, GenericCallback<T> callback) {
		ensureInitialized();
		uiNative(JSNIHelper.createObject(options), callback);
	}

	public void fireAuthLoginEvent(LoginStatus loginStatus) {
		handlerManager
				.fireEvent(new AuthEvent(AuthEventType.LOGIN, loginStatus));
	}

	public void fireAuthLogoutEvent(LoginStatus loginStatus) {
		handlerManager.fireEvent(new AuthEvent(AuthEventType.LOGOUT,
				loginStatus));
	}

	public void fireAuthResponseChangeEvent(LoginStatus loginStatus) {
		handlerManager.fireEvent(new AuthEvent(AuthEventType.RESPONSE_CHANGE,
				loginStatus));
	}

	public void fireAuthStatusChangeEvent(LoginStatus loginStatus) {
		handlerManager.fireEvent(new AuthEvent(AuthEventType.STATUS_CHANGE,
				loginStatus));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin#initialize()
	 */
	@Override
	public void initialize() {
		ensurePluginInstalled();
		addJsHandlers();
		initialized = true;
	}

	private void ensurePluginInstalled() {
		if (!isPluginInstalled()) {
			throw new IllegalStateException(
					"Can't find Facebook plugin - did you include neccessary javascript files?");
		}
	}

	private void ensureInitialized() {
		if (!initialized) {
			throw new IllegalStateException("you have to initialize Facebook Plugin before using it");
		}
	}

	private native boolean initializeNative(JavaScriptObject options)
	/*-{
        options.nativeInterface = $wnd.CDV.FB;
        $wnd.FB.init(options);
    }-*/;

	private native boolean isPluginInstalled()
	/*-{
        if (!$wnd.FB)
            return false;
        if (!$wnd.CDV)
            return false;
        if (!$wnd.CDV.FB)
            return false;
        return true;
    }-*/;

	private native void getLoginStatusNative(LoginStatusCallback callback)
	/*-{
        $wnd.FB.getLoginStatus(
            function (response) {
                if (callback)
                    callback.@com.googlecode.gwtphonegap.client.plugins.facebook.callback.LoginStatusCallback::onResponse(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/LoginStatus;)(response);
            });
    }-*/;

	private void ensureScope(Map<String, Object> options) {
		if (options.get("scope") == null) {
			options.put("scope", "");
		}
	}

	private native void loginNative(JavaScriptObject options,
									LoginStatusCallback callback)
	/*-{
        $wnd.FB.login(
            function (response) {
                if (callback) {
                    callback.@com.googlecode.gwtphonegap.client.plugins.facebook.callback.LoginStatusCallback::onResponse(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/LoginStatus;)(response);
                }
            },
            options);
    }-*/;

	private native void logoutNative()
	/*-{
        $wnd.FB.logout();
    }-*/;

	private native <T extends JavaScriptObject> void apiNative(String path,
															   JavaScriptObject options, GenericCallback<T> callback)
	/*-{
        $wnd.FB.api(
            path,
            options,
            function (result) {
                if (callback) {
                    if (result.error)
                        callback.@com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback::onError(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/ErrorResponse;)(result.error);
                    else {
                        callback.@com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback::onResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(result);
                    }
                }
            });
    }-*/;

	private native <T extends JavaScriptObject> void uiNative(
			JavaScriptObject options, GenericCallback<T> callback)
	/*-{
        $wnd.FB.ui(
            options,
            function (result) {
                if (callback) {
                    if (result.error)
                        callback.@com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback::onError(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/ErrorResponse;)(result.error);
                    else
                        callback.@com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback::onResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(result);

                }
            });
    }-*/;

	private void ensureHandlers() {
		if (handlerManager == null) {
			handlerManager = createHandlerManager();
		}
	}

	private HandlerManager createHandlerManager() {
		return new HandlerManager(this);
	}

	private native void addJsHandlers()
	/*-{
        var that = this;
        $wnd.FB.Event.subscribe('auth.login',
            function (response) {
                that.@com.googlecode.gwtphonegap.client.plugins.facebook.impl.FacebookJsImpl::fireAuthLoginEvent(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/LoginStatus;)(response);
            });
        $wnd.FB.Event.subscribe('auth.logout',
            function (response) {
                that.@com.googlecode.gwtphonegap.client.plugins.facebook.impl.FacebookJsImpl::fireAuthLogoutEvent(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/LoginStatus;)(response);
            });
        $wnd.FB.Event.subscribe('auth.sessionChange',
            function (response) {
                that.@com.googlecode.gwtphonegap.client.plugins.facebook.impl.FacebookJsImpl::fireAuthResponseChangeEvent(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/LoginStatus;)(response);
            });
        $wnd.FB.Event.subscribe('auth.statusChange',
            function (response) {
                that.@com.googlecode.gwtphonegap.client.plugins.facebook.impl.FacebookJsImpl::fireAuthStatusChangeEvent(Lcom/googlecode/gwtphonegap/client/plugins/facebook/jsni/LoginStatus;)(response);
            });
    }-*/;


}
