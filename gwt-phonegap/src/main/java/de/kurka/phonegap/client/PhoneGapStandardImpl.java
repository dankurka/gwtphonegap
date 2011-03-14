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
import de.kurka.phonegap.client.camera.Camera;
import de.kurka.phonegap.client.device.Device;
import de.kurka.phonegap.client.geolocation.Geolocation;
import de.kurka.phonegap.client.log.DebugLogger;
import de.kurka.phonegap.client.network.Network;
import de.kurka.phonegap.client.notification.Notification;

public class PhoneGapStandardImpl implements PhoneGap {

	private static final int INIT_TICK = 10;

	private Device device;

	private Accelerometer accelerometer;
	private Camera camera;
	private Geolocation geolocation;
	private Network network;
	private Notification notification;
	private DebugLogger debugLogger;

	private EventBus handlerManager = new SimpleEventBus();

	public PhoneGapStandardImpl() {

	}

	@Override
	public native boolean isPhoneGapInitialized()/*-{
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
	public Network getNetwork() {
		return network;
	}

	@Override
	public Notification getNotification() {
		return notification;
	}

	@Override
	public DebugLogger getDebugLogger() {
		return debugLogger;
	}

	private void firePhoneGapAvailable() {
		constructModules();

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

	protected Network constructNetwork() {
		return GWT.create(Network.class);
	}

	protected Notification constructNotification() {
		return GWT.create(Notification.class);
	}

	protected DebugLogger constructDebugLogger() {
		return GWT.create(DebugLogger.class);
	}

	protected void constructModules() {
		device = constructDevice();
		accelerometer = constructAccelerometer();
		camera = constructCamera();
		geolocation = constructGeolocation();
		network = constructNetwork();
		notification = constructNotification();
		debugLogger = constructDebugLogger();

	}
}
