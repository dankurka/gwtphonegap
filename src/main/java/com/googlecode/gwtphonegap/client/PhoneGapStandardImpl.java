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

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Timer;
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
import com.googlecode.gwtphonegap.client.log.PhoneGapLogStandardImpl;
import com.googlecode.gwtphonegap.client.media.MediaModule;
import com.googlecode.gwtphonegap.client.notification.Notification;
import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;

public class PhoneGapStandardImpl implements PhoneGap {

	private static final int INIT_TICK = 10;

	private Device device;

	private Accelerometer accelerometer;
	private Camera camera;
	private Geolocation geolocation;
	private Notification notification;
	private Contacts contacts;
	private File file;
	private Connection connection;
	private Event event;
	private MediaModule mediaModule;
	private Compass compass;
	private Capture capture;

	private Map<String, PhoneGapPlugin> plugins = new HashMap<String, PhoneGapPlugin>();

	private EventBus handlerManager = new SimpleEventBus();

	private PhoneGapLogStandardImpl phoneGapLog;

	public PhoneGapStandardImpl() {
		// log configures it self
		getLog();
	}

	public PhoneGapLog getLog() {
		if (phoneGapLog == null) {
			phoneGapLog = new PhoneGapLogStandardImpl();
		}
		return phoneGapLog;
	}

	@Override
	public native boolean isPhoneGapInitialized()/*-{
		//phonegap 1.5 ios
		if(!(typeof($wnd.Cordova) == "undefined")){
			return $wnd.Cordova.available;
		}
		
		//phonegap 1.5 android and others
		if(!(typeof($wnd.cordova) == "undefined")){
			return $wnd.cordova.available;
		}
		
		if (typeof ($wnd.PhoneGap) == "undefined") {
			return false;
		} else {
			return $wnd.PhoneGap.available;
		}
	}-*/;

	@Override
	public void initializePhoneGap() {
		initializePhoneGap(10000);
	}

	@Override
	public void initializePhoneGap(final int timeoutInMs) {

		final long end = System.currentTimeMillis() + timeoutInMs;
		if (isPhoneGapInitialized()) {

			firePhoneGapAvailable();

		} else {
			Timer timer = new Timer() {

				@Override
				public void run() {
					if (isPhoneGapInitialized()) {
						firePhoneGapAvailable();
						return;
					}

					if (System.currentTimeMillis() - end > 0) {
						handlerManager.fireEvent(new PhoneGapTimeoutEvent());
					} else {
						schedule(INIT_TICK);
					}

				}
			};

			timer.schedule(INIT_TICK);
		}
	}

	@Override
	public HandlerRegistration addHandler(PhoneGapAvailableHandler handler) {
		return handlerManager.addHandler(PhoneGapAvailableEvent.TYPE, handler);
	}

	@Override
	public HandlerRegistration addHandler(PhoneGapTimeoutHandler handler) {
		return handlerManager.addHandler(PhoneGapTimeoutEvent.TYPE, handler);
	}

	@Override
	public Device getDevice() {
		return device;
	}

	@Override
	public Accelerometer getAccelerometer() {
		return accelerometer;
	}

	@Override
	public Camera getCamera() {
		return camera;
	}

	@Override
	public Geolocation getGeolocation() {
		return geolocation;
	}

	@Override
	public Notification getNotification() {
		return notification;
	}

	private void firePhoneGapAvailable() {

		constructModules();
		phoneGapLog.setClientId(getDevice().getUuid());

		handlerManager.fireEvent(new PhoneGapAvailableEvent());
	}

	protected Device constructDevice() {
		return GWT.create(Device.class);
	}

	protected Accelerometer constructAccelerometer() {
		return GWT.create(Accelerometer.class);
	}

	protected Camera constructCamera() {
		return GWT.create(Camera.class);
	}

	protected Geolocation constructGeolocation() {
		return GWT.create(Geolocation.class);
	}

	protected Notification constructNotification() {
		return GWT.create(Notification.class);
	}

	protected void constructModules() {
		device = constructDevice();
		accelerometer = constructAccelerometer();
		camera = constructCamera();
		geolocation = constructGeolocation();
		notification = constructNotification();
		contacts = constructContacts();
		file = constructFile();
		connection = constructConnection();
		event = constructEvent();
		mediaModule = constructMediaModule();
		compass = constructCompass();
		capture = constructCapture();

	}

	protected Capture constructCapture() {
		return GWT.create(Capture.class);
	}

	protected Compass constructCompass() {
		return GWT.create(Compass.class);
	}

	protected MediaModule constructMediaModule() {
		return GWT.create(MediaModule.class);
	}

	protected Event constructEvent() {
		return GWT.create(Event.class);
	}

	protected Connection constructConnection() {
		return GWT.create(Connection.class);
	}

	protected File constructFile() {
		return GWT.create(File.class);
	}

	protected Contacts constructContacts() {
		return GWT.create(Contacts.class);
	}

	@Override
	public Contacts getContacts() {
		return contacts;
	}

	@Override
	public PhoneGapPlugin getPluginById(String id) {
		return plugins.get(id);
	}

	@Override
	public void loadPlugin(String id, PhoneGapPlugin instance) {
		if (plugins.containsKey(id)) {
			throw new IllegalStateException("id is already in use");
		}

		plugins.put(id, instance);
	}

	@Override
	public File getFile() {
		return file;
	}

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public Event getEvent() {
		return event;
	}

	@Override
	public native boolean exitApp() /*-{
		if ($wnd.navigator.app != null) {
			if ($wnd.navigator.app.exitApp != null) {
				$wnd.navigator.app.exitApp();
				return true;
			}
		}
		return false;

	}-*/;

	@Override
	public MediaModule getMedia() {
		return mediaModule;
	}

	@Override
	public Compass getCompass() {
		return compass;
	}

	@Override
	public Capture getCapture() {
		return capture;
	}

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.PhoneGap#isDevMode()
	 */
	@Override
	public boolean isDevMode() {
		return !GWT.isScript();
	}

}
