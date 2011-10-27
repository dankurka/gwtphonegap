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
package com.googlecode.gwtphonegap.client;

import com.google.gwt.event.shared.HandlerRegistration;
import com.googlecode.gwtphonegap.client.accelerometer.Accelerometer;
import com.googlecode.gwtphonegap.client.camera.Camera;
import com.googlecode.gwtphonegap.client.capture.Capture;
import com.googlecode.gwtphonegap.client.compass.Compass;
import com.googlecode.gwtphonegap.client.connection.Connection;
import com.googlecode.gwtphonegap.client.contacts.Contacts;
import com.googlecode.gwtphonegap.client.device.Device;
import com.googlecode.gwtphonegap.client.event.Event;
import com.googlecode.gwtphonegap.client.file.File;
import com.googlecode.gwtphonegap.client.geolocation.Geolocation;
import com.googlecode.gwtphonegap.client.log.PhoneGapLog;
import com.googlecode.gwtphonegap.client.media.MediaModule;
import com.googlecode.gwtphonegap.client.notification.Notification;
import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;

/**
 * This class is a wrapper class for phonegap.js
 * 
 * The implementation is based on {@link http://docs.phonegap.com/}
 * 
 * Available modules are:
 * <ul>
 * <li>Accelerometer</li>
 * <li>Camera</li>
 * <li>Capture</li>
 * <li>Compass</li>
 * <li>Conntection</li>
 * <li>Contacts</li>
 * <li>Device</li>
 * <li>Events</li>
 * <li>File</li>
 * <li>Geolocation</li>
 * <li>Media</li>
 * <li>Log</li>
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
	 * @param timeoutInMs the timeout in milliseconds
	 */
	public void initializePhoneGap(final int timeoutInMs);

	/**
	 * Add a handler for {@link PhoneGapAvaibleEvent}
	 * 
	 * @param handler the handler to add
	 * @return the handler registration
	 */
	public HandlerRegistration addHandler(PhoneGapAvailableHandler handler);

	/**
	 * Add a handler for {@link PhoneGapTimeoutEvent}
	 * 
	 * @param handler the handler to add
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

	public Contacts getContacts();

	public PhoneGapPlugin getPluginById(String name);

	public void loadPlugin(String id, PhoneGapPlugin instance);

	public File getFile();

	public Event getEvent();

	// testing for android....
	public boolean exitApp();

	public MediaModule getMedia();

	public Compass getCompass();

	public Capture getCapture();

	public PhoneGapLog getLog();

	public boolean isDevMode();

}