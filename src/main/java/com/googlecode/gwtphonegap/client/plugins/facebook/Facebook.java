package com.googlecode.gwtphonegap.client.plugins.facebook;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;
import com.googlecode.gwtphonegap.client.plugins.facebook.callback.GenericCallback;
import com.googlecode.gwtphonegap.client.plugins.facebook.callback.LoginStatusCallback;
import com.googlecode.gwtphonegap.client.plugins.facebook.event.AuthHandler;

import java.util.Map;

/**
 * Howto use the plugin:
 * <p/>
 * // create an instance of the plugin
 * Facebook facebook = GWT.create(Facebook.class);
 * <p/>
 * // register event handler
 * facebook.addAuthHandler(new AuthHandler() {
 * // ... implement the Authhandler to your needs. It handles login, logout, response change and status change events
 * };
 * <p/>
 * // initialize
 * Map<String, Object> settings = Maps.newHashMap();
 * settings.put("appId", "your app id");
 * settings.put("useCachedDialogs", false);
 * settings.put("status", true);
 * facebook.initialize(settings);
 * <p/>
 * // login
 * HashMap<String, Object> options = Maps.<String, Object> newHashMap();
 * options.put("scope", "email");
 * facebook.login(options, null);
 * <p/>
 * // fetch user data
 * facebook.api("me", null, new GenericCallback<ApiResponse>() {
 * // ... implement the callback to your needs. Also ApiResponse is just a basic response overlay type.
 * //     You can replace it with your own one. The GenericCallback will accept any type derived from JavascriptObject.
 * });
 */
public interface Facebook extends PhoneGapPlugin {

	/**
	 * Register for authentication event types (login, logout, response change,
	 * status change)
	 *
	 * @param handler
	 * @return
	 */
	HandlerRegistration addAuthHandler(AuthHandler handler);

	/**
	 * Initialize options for the library
	 *
	 * @param options for instance the appId value. For a complete list of possible
	 *                parameters have a look into:
	 *                <a>https://github.com/phonegap/phonegap-facebook
	 *                -plugin/blob/master/www/facebook_js_sdk.js</a> Search for
	 *                "init:"
	 */
	void initialize(Map<String, Object> options);

	/**
	 * Check the login status
	 *
	 * @param callback is called if login status is retrieved
	 * @param force fetching login status from facebook server
	 */
	void getLoginStatus(LoginStatusCallback callback, boolean force);

	/**
	 * Login into Facebook
	 *
	 * @param options like the scope. For a complete list of possible parameters
	 *                have a look into:
	 *                <a>https://github.com/phonegap/phonegap-facebook
	 *                -plugin/blob/master/www/facebook_js_sdk.js</a> Search for
	 *                "login:"
	 */
	void login(Map<String, Object> options, LoginStatusCallback callback);

	/**
	 * Logout from Facebook
	 */
	void logout();

	/**
	 * Request Facebook Graph API
	 *
	 * @param path     like "/me/friends"
	 * @param options  Optional, can be null example: { fields: 'id, name, picture' }
	 *                 For a complete list of possible parameters have a look into:
	 *                 <a>https://github.com/phonegap/phonegap-facebook
	 *                 -plugin/blob/master/www/facebook_js_sdk.js</a> Search for
	 *                 "api:"
	 * @param callback Optional, GenericCallback will call onResponse method with
	 *                 generic overlay type. Please adapt your overlay type to the
	 *                 corresponding response json. There is already a overlay type
	 *                 for basic user data <code>ApiResponse</code> which can be
	 *                 extended to your needs.
	 */
	<T extends JavaScriptObject> void api(String path,
										  Map<String, String> options, GenericCallback<T> callback);

	/**
	 * Makes interaction with the ui. For a complete list of possible parameters
	 * have a look into: <a>https://github.com/phonegap/phonegap-facebook
	 * -plugin/blob/master/www/facebook_js_sdk.js</a> Search for "ui:"
	 *
	 * @param method
	 * @param options
	 * @param callback
	 */
	<T extends JavaScriptObject> void ui(String method,
										 Map<String, String> options, GenericCallback<T> callback);

	/**
	 * Sets the EventBus to use by the implementation
	 * @param eventBus
	 */
	void setEventBus(EventBus eventBus);
}
