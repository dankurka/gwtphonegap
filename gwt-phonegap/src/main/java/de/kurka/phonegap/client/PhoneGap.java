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
package de.kurka.phonegap.client;

import com.google.gwt.event.shared.HandlerRegistration;

import de.kurka.phonegap.client.accelerometer.Accelerometer;
import de.kurka.phonegap.client.camera.Camera;
import de.kurka.phonegap.client.connection.Connection;
import de.kurka.phonegap.client.contacts.Contacts;
import de.kurka.phonegap.client.device.Device;
import de.kurka.phonegap.client.event.Event;
import de.kurka.phonegap.client.file.File;
import de.kurka.phonegap.client.geolocation.Geolocation;
import de.kurka.phonegap.client.log.DebugLogger;
import de.kurka.phonegap.client.media.MediaModule;
import de.kurka.phonegap.client.notification.Notification;
import de.kurka.phonegap.client.plugins.PhoneGapPlugin;

/**
 * This class is a wrapper class for phonegap.js
 * 
 * The implementation is based on {@link http://docs.phonegap.com/}
 * 
 * Available modules are:
 * <ul>
 * <li>Accelerometer</li>
 * <li>Camera</li>
 * <li>Device</li>
 * <li>File</li>
 * <li>Geolocation</li>
 * <li>Log</li>
 * <li>Network</li>
 * <li>Notification</li>
 * </ul>
 * 
 * 
 * 
 * @author Daniel Kurka
 * 
 */
public interface PhoneGap {

	/**
	 * Determine if phonegap is initialized
	 * 
	 * @return true if phonegap is initialized
	 */
	public boolean isPhoneGapInitialized();

	/**
	 * Initializes Phonegap with a default timeout see:
	 * {@link PhoneGapStandardImpl#initializePhoneGap(int)}
	 */
	public void initializePhoneGap();

	/**
	 * initialize Phonegap
	 * 
	 * If Phonegap is initialized successfully within timeout a
	 * {@link PhoneGapAvaibleEvent} is fired, else a
	 * {@link PhoneGapTimeoutEvent} is fired
	 * 
	 * @param timeoutInMs
	 *            the timeout in milliseconds
	 */
	public void initializePhoneGap(final int timeoutInMs);

	/**
	 * Add a handler for {@link PhoneGapAvaibleEvent}
	 * 
	 * @param handler
	 *            the handler to add
	 * @return the handler registration
	 */
	public HandlerRegistration addHandler(PhoneGapAvailableHandler handler);

	/**
	 * Add a handler for {@link PhoneGapTimeoutEvent}
	 * 
	 * @param handler
	 *            the handler to add
	 * @return the handler registration
	 */
	public HandlerRegistration addHandler(PhoneGapTimeoutHandler handler);

	/**
	 * get the phonegap device object
	 * 
	 * @return the device object containing device specific information
	 */
	public Device getDevice();

	/**
	 * get the phonegap accelerometer object
	 * 
	 * @return
	 */
	public Accelerometer getAccelerometer();

	/**
	 * get the phonegap camera object
	 * 
	 * @return
	 */
	public Camera getCamera();

	/**
	 * get the phonegap geolocation object
	 * 
	 * @return
	 */
	public Geolocation getGeolocation();

	public Connection getConnection();

	/**
	 * get the phonegap notification object
	 * 
	 * @return
	 */
	public Notification getNotification();

	/**
	 * get the phonegap debuglogger object
	 * 
	 * @return
	 */
	public DebugLogger getDebugLogger();

	public Contacts getContacts();

	public PhoneGapPlugin getPluginById(String name);

	public void loadPlugin(String id, PhoneGapPlugin instance);

	public File getFile();

	public Event getEvent();

	//testing for android....
	public boolean exitApp();

	public MediaModule getMedia();

}