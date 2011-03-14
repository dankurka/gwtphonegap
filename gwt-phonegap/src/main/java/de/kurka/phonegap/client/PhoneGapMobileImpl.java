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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Timer;

import de.kurka.phonegap.client.accelerometer.Accelerometer;
import de.kurka.phonegap.client.accelerometer.AccelerometerMobileImpl;
import de.kurka.phonegap.client.camera.Camera;
import de.kurka.phonegap.client.camera.CameraMobileImpl;
import de.kurka.phonegap.client.device.Device;
import de.kurka.phonegap.client.geolocation.Geolocation;
import de.kurka.phonegap.client.geolocation.GeolocationMobileImpl;
import de.kurka.phonegap.client.log.DebugLogger;
import de.kurka.phonegap.client.log.DebugLoggerMobileImpl;
import de.kurka.phonegap.client.network.Network;
import de.kurka.phonegap.client.network.NetworkMobileImpl;
import de.kurka.phonegap.client.notification.Notification;
import de.kurka.phonegap.client.notification.NotificationMobileImpl;

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
public class PhoneGapMobileImpl implements PhoneGap {

	private static final int INIT_TICK = 10;

	private Device device;

	private Accelerometer accelerometer;
	private Camera camera;
	private Geolocation geolocation;
	private Network network;
	private Notification notification;
	private DebugLogger debugLogger;

	private EventBus handlerManager = new SimpleEventBus();

	public PhoneGapMobileImpl() {

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#isPhoneGapInitialized()
	 */
	@Override
	public native boolean isPhoneGapInitialized()/*-{
		if(typeof($wnd.PhoneGap) == "undefined"){
		return false;
		}else{
		return $wnd.PhoneGap.available;
		}
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#initializePhoneGap()
	 */
	@Override
	public void initializePhoneGap() {
		initializePhoneGap(10000);
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#initializePhoneGap(int)
	 */
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

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#addHandler(de.kurka.phonegap.client.PhoneGapAvailableHandler)
	 */
	@Override
	public HandlerRegistration addHandler(PhoneGapAvailableHandler handler) {
		return handlerManager.addHandler(PhoneGapAvailableEvent.TYPE, handler);
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#addHandler(de.kurka.phonegap.client.PhoneGapTimeoutHandler)
	 */
	@Override
	public HandlerRegistration addHandler(PhoneGapTimeoutHandler handler) {
		return handlerManager.addHandler(PhoneGapTimeoutEvent.TYPE, handler);
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getDevice()
	 */
	@Override
	public Device getDevice() {
		return device;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getAccelerometer()
	 */
	@Override
	public Accelerometer getAccelerometer() {
		return accelerometer;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getCamera()
	 */
	@Override
	public Camera getCamera() {
		return camera;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getGeolocation()
	 */
	@Override
	public Geolocation getGeolocation() {
		return geolocation;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getNetwork()
	 */
	@Override
	public Network getNetwork() {
		return network;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getNotification()
	 */
	@Override
	public Notification getNotification() {
		return notification;
	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.IPhoneGap#getDebugLogger()
	 */
	@Override
	public DebugLogger getDebugLogger() {
		return debugLogger;
	}

	private void firePhoneGapAvailable() {
		constructModules();

		handlerManager.fireEvent(new PhoneGapAvailableEvent());
	}

	private void constructModules() {
		device = GWT.create(Device.class);
		accelerometer = GWT.create(Accelerometer.class);
		camera = GWT.create(Camera.class);
		geolocation = GWT.create(Geolocation.class);
		network = GWT.create(Network.class);
		notification = GWT.create(Notification.class);
		debugLogger = GWT.create(DebugLogger.class);

	}
}
