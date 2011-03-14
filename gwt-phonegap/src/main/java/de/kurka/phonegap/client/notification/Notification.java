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

public interface Notification {

	/**
	 * Is the Notification module available
	 * 
	 * @return true if its available
	 */
	public abstract boolean isAvailable();

	/**
	 * {@link NotificationMobileImpl#alert(String, String, String)}
	 */
	public abstract void alert(String message);

	/**
	 * {@link NotificationMobileImpl#alert(String, String, String)}
	 */
	public abstract void alert(String message, String title);

	/**
	 * Shows an alert or dialog box.
	 * 
	 * Most PhoneGap implementations use a native dialog box for this feature.
	 * However, some platforms simply use the browser's alert function, which is
	 * typically less customizable.
	 * 
	 * <h1>Supported Platforms:</h1>
	 * 
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry (OS 4.6)</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 * 
	 * @param message
	 * @param title
	 * @param buttonName
	 * 
	 */
	public abstract void alert(String message, String title, String buttonName);

	/**
	 * The device will play a beep sound.
	 * 
	 * <h1>Supported Platforms:</h1>
	 * 
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry (OS 4.6)</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 * 
	 * 
	 * <h1>Android Quirks</h1>
	 * 
	 * <ul>
	 * <li>Android plays the default "Notification ringtone" specified under the
	 * "Settings/Sound & Display" panel.</li>
	 * </ul>
	 * 
	 * 
	 * <h1>iPhone Quirks</h1>
	 * 
	 * <ul>
	 * <li>Ignores the beep count argument.</li>
	 * <li>There is no native beep API for iPhone.
	 * <ul>
	 * <li>PhoneGap implements beep by playing an audio file via the media API.</li>
	 * <li>The user must provide a file with the desired beep tone.</li>
	 * <li>This file must be less than 30 seconds long, located in the www/
	 * root, and must be named beep.wav.</li>
	 * </ul>
	 * </li>
	 * </ul>
	 * 
	 * @param count
	 *            The number of times to repeat the beep
	 */
	public abstract void beep(int count);

	/**
	 * Vibrates the device for the specified amount of time.
	 * 
	 * <h1>Supported Platforms:</h1>
	 * 
	 * <ul>
	 * <li>Android</li>
	 * <li>BlackBerry (OS 4.6)</li>
	 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
	 * <li>iPhone</li>
	 * </ul>
	 * 
	 * 
	 * <h1>iPhone Quirks</h1>
	 * <ul>
	 * <li>time: Ignores the time and vibrates for a pre-set amount of time.</li>
	 * </ul>
	 * 
	 * 
	 * @param milliseconds
	 *            Milliseconds to vibrate the device. 1000 milliseconds equals 1
	 *            second
	 */
	public abstract void vibrate(int milliseconds);

}