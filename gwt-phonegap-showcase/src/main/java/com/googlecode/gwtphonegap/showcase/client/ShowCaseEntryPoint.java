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
package com.googlecode.gwtphonegap.showcase.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.plugins.childbrowser.ChildBrowser;
import com.googlecode.gwtphonegap.showcase.client.accelerometer.AccelerometerDisplay;
import com.googlecode.gwtphonegap.showcase.client.accelerometer.AccelerometerPresenter;
import com.googlecode.gwtphonegap.showcase.client.camera.CameraDisplay;
import com.googlecode.gwtphonegap.showcase.client.camera.CameraPresenter;
import com.googlecode.gwtphonegap.showcase.client.compass.CompassDisplay;
import com.googlecode.gwtphonegap.showcase.client.compass.CompassPresenter;
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionDisplay;
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionPresenter;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactDisplay;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactPresenter;
import com.googlecode.gwtphonegap.showcase.client.device.DeviceDisplay;
import com.googlecode.gwtphonegap.showcase.client.device.DevicePresenter;
import com.googlecode.gwtphonegap.showcase.client.event.EventDisplay;
import com.googlecode.gwtphonegap.showcase.client.event.EventPresenter;
import com.googlecode.gwtphonegap.showcase.client.file.FileDisplayGwtImpl;
import com.googlecode.gwtphonegap.showcase.client.file.FilePresenter;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationDisplay;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationPresenter;
import com.googlecode.gwtphonegap.showcase.client.media.MediaDisplay;
import com.googlecode.gwtphonegap.showcase.client.media.MediaPresenter;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationDisplay;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationPresenter;
import com.googlecode.gwtphonegap.showcase.client.plugin.ChildBrowserDisplay;
import com.googlecode.gwtphonegap.showcase.client.plugin.ChildBrowserPresenter;

public class ShowCaseEntryPoint implements EntryPoint {
	private Logger log = Logger.getLogger(getClass().getName());

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				Window.alert("uncaught: " + e.getLocalizedMessage());
				Window.alert(e.getMessage());
				log.log(Level.SEVERE, "uncaught exception", e);
			}
		});

		final PhoneGap phoneGap = GWT.create(PhoneGap.class);

		phoneGap.addHandler(new PhoneGapAvailableHandler() {

			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
				startShowCase(phoneGap);

			}
		});

		phoneGap.addHandler(new PhoneGapTimeoutHandler() {

			@Override
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				Window.alert("can not load phonegap");

			}
		});

		phoneGap.initializePhoneGap();

	}

	private void startShowCase(PhoneGap phoneGap) {
		// load plugin
		ChildBrowser cb = (ChildBrowser) GWT.create(ChildBrowser.class);
		cb.initialize();
		phoneGap.loadPlugin("childBrowser", cb);

		DevicePresenter devicePresenter = new DevicePresenter(new DeviceDisplay(), phoneGap);
		GeolocationPresenter geolocationPresenter = new GeolocationPresenter(new GeolocationDisplay(), phoneGap);
		NotificationPresenter notificationPresenter = new NotificationPresenter(new NotificationDisplay(), phoneGap);
		AboutPresenter aboutPresenter = new AboutPresenter(new AboutDisplay());
		CameraPresenter cameraPresenter = new CameraPresenter(new CameraDisplay(), phoneGap);
		ConnectionPresenter connectionPresenter = new ConnectionPresenter(new ConnectionDisplay(), phoneGap);
		ContactPresenter contactPresenter = new ContactPresenter(new ContactDisplay(), phoneGap);
		EventPresenter eventPresenter = new EventPresenter(new EventDisplay(), phoneGap);
		MediaPresenter mediaPresenter = new MediaPresenter(new MediaDisplay(), phoneGap);
		CompassPresenter compassPresenter = new CompassPresenter(new CompassDisplay(), phoneGap);
		FilePresenter filePresenter = new FilePresenter(new FileDisplayGwtImpl(), phoneGap);
		ChildBrowserPresenter childBrowserPresenter = new ChildBrowserPresenter(new ChildBrowserDisplay(), phoneGap);

		MainPresenter mainPresenter = new MainPresenter(new MainDisplay(), phoneGap, new AccelerometerPresenter(new AccelerometerDisplay(), phoneGap), devicePresenter, geolocationPresenter,
				notificationPresenter, aboutPresenter, cameraPresenter, connectionPresenter, contactPresenter, eventPresenter, mediaPresenter, compassPresenter, filePresenter, childBrowserPresenter);

		RootPanel.get().add(mainPresenter.getDisplay().asWidget());

		mainPresenter.start();
	}

}
