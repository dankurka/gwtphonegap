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

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Ronny Bubke
 * 
 */
public interface AuthHandler extends EventHandler {

	/**
	 * This event is fired when your app first notices the user (in other words,
	 * gets a session when it didn't already have a valid one).
	 * 
	 * @param event
	 */
	void onLogin(AuthEvent event);

	/**
	 * This event is fired when your app notices that there is no longer a valid
	 * user (in other words, it had a session but can no longer validate the
	 * current user).
	 * 
	 * @param event
	 */
	void onLogout(AuthEvent event);

	/**
	 * This event is fired for any auth related change as they all affect the
	 * session: login, logout, session refresh. Sessions are refreshed over time
	 * as long as the user is active with your app.
	 * 
	 * @param event
	 */
	void onResponseChange(AuthEvent event);

	/**
	 * Typically you will want to use the auth.authResponseChange event. But in
	 * rare cases, you want to distinguish between connected, not_authorized or
	 * unknown.
	 * 
	 * @param event
	 */
	void onStatusChange(AuthEvent event);
}
