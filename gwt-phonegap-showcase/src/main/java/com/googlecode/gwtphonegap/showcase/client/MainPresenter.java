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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.showcase.client.accelerometer.AccelerometerPresenter;
import com.googlecode.gwtphonegap.showcase.client.camera.CameraPresenter;
import com.googlecode.gwtphonegap.showcase.client.compass.CompassPresenter;
import com.googlecode.gwtphonegap.showcase.client.connection.ConnectionPresenter;
import com.googlecode.gwtphonegap.showcase.client.contact.ContactPresenter;
import com.googlecode.gwtphonegap.showcase.client.device.DevicePresenter;
import com.googlecode.gwtphonegap.showcase.client.event.EventPresenter;
import com.googlecode.gwtphonegap.showcase.client.file.FilePresenter;
import com.googlecode.gwtphonegap.showcase.client.geolocation.GeolocationPresenter;
import com.googlecode.gwtphonegap.showcase.client.media.MediaPresenter;
import com.googlecode.gwtphonegap.showcase.client.notification.NotificationPresenter;
import com.googlecode.gwtphonegap.showcase.client.plugin.ChildBrowserPresenter;

public class MainPresenter {

	private final Display display;
	private final AccelerometerPresenter accelerometerPresenter;
	private final DevicePresenter devicePresenter;
	private final GeolocationPresenter geolocationPresenter;
	private final NotificationPresenter notificationPresenter;
	private final AboutPresenter aboutPresenter;
	private final CameraPresenter cameraPresenter;
	private final ConnectionPresenter connectionPresenter;
	private final ContactPresenter contactPresenter;
	private final EventPresenter eventPresenter;
	private final PhoneGap phoneGap;
	private final MediaPresenter mediaPresenter;
	private final CompassPresenter compassPresenter;
	private final FilePresenter filePresenter;
	private final ChildBrowserPresenter childBrowserPresenter;

	public MainPresenter(Display display, PhoneGap phoneGap, AccelerometerPresenter accelerometerPresenter, DevicePresenter devicePresenter, GeolocationPresenter geolocationPresenter,
			NotificationPresenter notificationPresenter, AboutPresenter aboutPresenter, CameraPresenter cameraPresenter, ConnectionPresenter connectionPresenter, ContactPresenter contactPresenter,
			EventPresenter eventPresenter, MediaPresenter mediaPresenter, CompassPresenter compassPresenter, FilePresenter filePresenter, ChildBrowserPresenter childBrowserPresenter) {
		this.display = display;
		this.phoneGap = phoneGap;
		this.accelerometerPresenter = accelerometerPresenter;
		this.devicePresenter = devicePresenter;
		this.geolocationPresenter = geolocationPresenter;
		this.notificationPresenter = notificationPresenter;
		this.aboutPresenter = aboutPresenter;
		this.cameraPresenter = cameraPresenter;
		this.connectionPresenter = connectionPresenter;
		this.contactPresenter = contactPresenter;
		this.eventPresenter = eventPresenter;
		this.mediaPresenter = mediaPresenter;
		this.compassPresenter = compassPresenter;
		this.filePresenter = filePresenter;
		this.childBrowserPresenter = childBrowserPresenter;

		bind();

	}

	private void bind() {
		display.getExitButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				phoneGap.exitApp();

			}
		});

	}

	public interface Display {
		public Widget asWidget();

		public HasWidgets getContainer();

		public HasClickHandlers getExitButton();

	}

	public Display getDisplay() {
		return display;
	}

	public void start() {
		display.getContainer().add(accelerometerPresenter.getDisplay().asWidget());
		display.getContainer().add(cameraPresenter.getDisplay().asWidget());
		display.getContainer().add(compassPresenter.getDisplay().asWidget());
		display.getContainer().add(connectionPresenter.getDisplay().asWidget());
		display.getContainer().add(contactPresenter.getDisplay().asWidget());
		display.getContainer().add(devicePresenter.getDisplay().asWidget());
		display.getContainer().add(eventPresenter.getDisplay().asWidget());
		display.getContainer().add(filePresenter.getDisplay().asWidget());
		display.getContainer().add(geolocationPresenter.getDisplay().asWidget());
		display.getContainer().add(mediaPresenter.getDisplay().asWidget());
		display.getContainer().add(notificationPresenter.getDisplay().asWidget());
		display.getContainer().add(aboutPresenter.getDisplay().asWidget());
		display.getContainer().add(childBrowserPresenter.getDisplay().asWidget());

	}
}
