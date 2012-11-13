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
package com.googlecode.gwtphonegap.client.plugins.childbrowser;

import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;

public interface ChildBrowser extends PhoneGapPlugin {

  /**
   * Display a new browser with the specified URL.
   * This method loads up a new web view in a dialog which
   * shows a location bar.
   *
   * @param url
   */
  public void showWebPage(String url);
  
  /**
   * Display a new browser with the specified URL.
   * This method loads up a new web view in a dialog.
   *
   * @param url
   * @param showLocationBar show the location bar
   */
  public void showWebPage(String url, boolean showLocationBar);

  /**
   * Display a new browser with the specified URL.
   * This method starts a new web browser activity.
   *
   * @param url
   * @param usecordova whether load url in cordova webview
   */
  public void openExternal(String url, boolean usecordova);

  /**
   * Close the browser opened by showWebPage.
   */
	public void close();

	public HandlerRegistration addLocationChangeHandler(ChildBrowserLocationChangedHandler handler);

	public HandlerRegistration addCloseHandler(ChildBrowserCloseHandler handler);

	public HandlerRegistration addOpenExternalHandler(ChildBrowserOpenExternalHandler handler);
}
