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
package de.kurka.phonegap.showcase.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.showcase.client.accelerometer.AccelerometerPresenter;
import de.kurka.phonegap.showcase.client.camera.CameraPresenter;
import de.kurka.phonegap.showcase.client.connection.ConnectionPresenter;
import de.kurka.phonegap.showcase.client.contact.ContactPresenter;
import de.kurka.phonegap.showcase.client.device.DevicePresenter;
import de.kurka.phonegap.showcase.client.event.EventPresenter;
import de.kurka.phonegap.showcase.client.geolocation.GeolocationPresenter;
import de.kurka.phonegap.showcase.client.media.MediaPresenter;
import de.kurka.phonegap.showcase.client.notification.NotificationPresenter;

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

	public MainPresenter(Display display, PhoneGap phoneGap, AccelerometerPresenter accelerometerPresenter, DevicePresenter devicePresenter, GeolocationPresenter geolocationPresenter,
			NotificationPresenter notificationPresenter, AboutPresenter aboutPresenter, CameraPresenter cameraPresenter, ConnectionPresenter connectionPresenter, ContactPresenter contactPresenter,
			EventPresenter eventPresenter, MediaPresenter mediaPresenter) {
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
		display.getContainer().add(connectionPresenter.getDisplay().asWidget());
		display.getContainer().add(contactPresenter.getDisplay().asWidget());
		display.getContainer().add(devicePresenter.getDisplay().asWidget());
		display.getContainer().add(eventPresenter.getDisplay().asWidget());
		display.getContainer().add(geolocationPresenter.getDisplay().asWidget());
		display.getContainer().add(mediaPresenter.getDisplay().asWidget());
		display.getContainer().add(notificationPresenter.getDisplay().asWidget());
		display.getContainer().add(aboutPresenter.getDisplay().asWidget());

	}
}
