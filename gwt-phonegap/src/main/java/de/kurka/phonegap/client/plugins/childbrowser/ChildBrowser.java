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
package de.kurka.phonegap.client.plugins.childbrowser;

import com.google.gwt.event.shared.HandlerRegistration;

import de.kurka.phonegap.client.plugins.PhoneGapPlugin;

public interface ChildBrowser extends PhoneGapPlugin {
	public void showWebPage(String url);

	public void close();

	public HandlerRegistration addLocationChangeHandler(ChildBrowserLocationChangedHandler handler);

	public HandlerRegistration addCloseHandler(ChildBrowserCloseHandler handler);

	public HandlerRegistration addOpenExternalHandler(ChildBrowserOpenExternalHandler handler);
}
