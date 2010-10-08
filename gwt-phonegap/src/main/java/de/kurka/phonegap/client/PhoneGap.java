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

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Timer;

import de.kurka.phonegap.client.accelerometer.Accelerometer;
import de.kurka.phonegap.client.camera.Camera;
import de.kurka.phonegap.client.device.Device;
import de.kurka.phonegap.client.geolocation.Geolocation;
import de.kurka.phonegap.client.log.DebugLogger;
import de.kurka.phonegap.client.network.Network;
import de.kurka.phonegap.client.notification.Notification;

/**
 * This class is a wrapper class for phonegap.js
 * 
 * The implementation is based on {@link http://docs.phonegap.com/}
 * 
 * Available modules are:
 *	<ul>
 * 		<li>Accelerometer</li>
 * 		<li>Camera</li>
 * 		<li>Device</li>
 * 		<li>File</li>
 * 		<li>Geolocation</li>
 * 		<li>Log</li>
 * 		<li>Network</li>
 * 		<li>Notification</li>
 * 	</ul>
 *
 * 
 * 
 * @author Daniel Kurka
 * 
 */
public class PhoneGap {

	private static final int INIT_TICK = 10;

	private Device device;

	private Accelerometer accelerometer;
	private Camera camera;
	private Geolocation geolocation;
	private Network network;
	private Notification notification;
	private DebugLogger debugLogger;

	private HandlerManager handlerManager = new HandlerManager(null);

	public PhoneGap() {

	}

	/**
	 * Determine if phonegap is initialized
	 * @return true if phonegap is initialized
	 */
	public native boolean isPhoneGapInitialized()/*-{
		if(typeof($wnd.PhoneGap) == "undefined"){
		return false;
		}else{
		return $wnd.PhoneGap.available;
		}
	}-*/;

	/**
	 * Initializes Phonegap with a default timeout see: {@link PhoneGap#initializePhoneGap(int)}
	 */
	public void initializePhoneGap() {
		initializePhoneGap(10000);
	}

	/**
	 * initialize Phonegap 
	 * 
	 * If Phonegap is initialized successfully within timeout a {@link PhoneGapAvaibleEvent} is fired, else a {@link PhoneGapTimeoutEvent} is fired
	 * 
	 * @param timeoutInMs the timeout in milliseconds
	 */
	public void initializePhoneGap(final int timeoutInMs) {
		final long end = System.currentTimeMillis() + timeoutInMs;
		if (isPhoneGapInitialized()) {

			DeferredCommand.addCommand(new Command() {

				@Override
				public void execute() {
					firePhoneGapAvaible();
				}

			});

		} else {
			Timer timer = new Timer() {

				@Override
				public void run() {
					if (isPhoneGapInitialized()) {
						firePhoneGapAvaible();
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

	/**
	 * Add a handler for {@link PhoneGapAvaibleEvent}
	 * @param handler the handler to add
	 * @return the handler registration
	 */
	public HandlerRegistration addHandler(PhoneGapAvaibleHandler handler) {
		return handlerManager.addHandler(PhoneGapAvaibleEvent.TYPE, handler);
	}

	/**
	 * Add a handler for {@link PhoneGapTimeoutEvent}
	 * @param handler the handler to add
	 * @return the handler registration
	 */
	public HandlerRegistration addHandler(PhoneGapTimeoutHandler handler) {
		return handlerManager.addHandler(PhoneGapTimeoutEvent.TYPE, handler);
	}

	/**
	 * get the phonegap device object
	 * @return the device object containing device specific information
	 */
	public Device getDevice() {
		return device;
	}

	/**
	 * get the phonegap accelerometer object
	 * @return
	 */
	public Accelerometer getAccelerometer() {
		return accelerometer;
	}

	/**
	 * get the phonegap camera object
	 * @return
	 */
	public Camera getCamera() {
		return camera;
	}

	/**
	 * get the phonegap geolocation object
	 * @return
	 */
	public Geolocation getGeolocation() {
		return geolocation;
	}

	/**
	 * get the phonegap network object
	 * @return
	 */
	public Network getNetwork() {
		return network;
	}

	/**
	 * get the phonegap notification object
	 * @return
	 */
	public Notification getNotification() {
		return notification;
	}

	/**
	 * get the phonegap debuglogger object
	 * @return
	 */
	public DebugLogger getDebugLogger() {
		return debugLogger;
	}

	private void firePhoneGapAvaible() {
		constructModules();

		handlerManager.fireEvent(new PhoneGapAvaibleEvent());
	}

	private void constructModules() {
		device = new Device();
		accelerometer = new Accelerometer();
		camera = new Camera();
		geolocation = new Geolocation();
		network = new Network();
		notification = new Notification();
		debugLogger = new DebugLogger();

	}
}
