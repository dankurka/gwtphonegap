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
package de.kurka.phonegap.client.notification;

import com.google.gwt.user.client.Window;

public class NotificationBrowserImpl implements Notification {

	@Override
	public void alert(String message) {
		Window.alert(message);

	}

	@Override
	public void alert(String message, String title) {
		alert(message);

	}

	@Override
	public void alert(String message, String title, String buttonName) {
		alert(message);

	}

	@Override
	public void beep(int count) {

	}

	@Override
	public void vibrate(int milliseconds) {

	}

}
