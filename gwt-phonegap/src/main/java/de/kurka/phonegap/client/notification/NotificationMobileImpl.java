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

/**
 * Visual, audible, and tactile device notifications.
 * 
 * @author Daniel Kurka
 * 
 */
public class NotificationMobileImpl implements Notification {

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.notification.Notification#alert(java.lang.String)
	 */
	@Override
	public void alert(String message) {
		alert(message, "Alert", "Ok");
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.notification.Notification#alert(java.lang.String, java.lang.String)
	 */
	@Override
	public void alert(String message, String title) {
		alert(message, title, "Ok");
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.notification.Notification#alert(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public native void alert(String message, String title, String buttonName)/*-{
		$wnd.navigator.notification.alert(message, title, buttonName);
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.notification.Notification#beep(int)
	 */
	@Override
	public native void beep(int count)/*-{
		$wnd.navigator.notification.beep(count);
	}-*/;

	// TODO put this back in after bug in confirm is fixed
	// /**
	// * {@link Notification#confirm(String, String, String)}
	// */
	// public int confirm(String message) {
	// return confirm(message, "Confirm", "Ok,Cancel");
	// }
	//
	// /**
	// * {@link Notification#confirm(String, String, String)}
	// */
	// public int confirm(String message, String title) {
	// return confirm(message, title, "Ok,Cancel");
	// }
	//
	// /**
	// * Shows a confirmation dialog box.
	// *
	// * <ul>
	// * <li>Android</li>
	// * <li>iPhone</li>
	// * </ul>
	// *
	// * @param message the message to display
	// * @param title the dialog title
	// * @param buttonLabel
	// * @return Index of the button clicked (1, 2 or 3).
	// */
	// public native int confirm(String message, String title, String
	// buttonLabel)/*-{
	// $wnd.navigator.notification.confirm(message, title, buttonLabel);
	// }-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.notification.Notification#vibrate(int)
	 */
	@Override
	public native void vibrate(int milliseconds)/*-{
		$wnd.navigator.notification.vibrate(milliseconds);
	}-*/;
}
