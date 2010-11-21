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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.PhoneGapAvailableEvent;
import de.kurka.phonegap.client.PhoneGapAvailableHandler;
import de.kurka.phonegap.client.PhoneGapTimeoutEvent;
import de.kurka.phonegap.client.PhoneGapTimeoutHandler;
import de.kurka.phonegap.showcase.client.accelerometer.AccelerometerDisplay;
import de.kurka.phonegap.showcase.client.accelerometer.AccelerometerPresenter;
import de.kurka.phonegap.showcase.client.device.DeviceDisplay;
import de.kurka.phonegap.showcase.client.device.DevicePresenter;
import de.kurka.phonegap.showcase.client.geolocation.GeolocationDisplay;
import de.kurka.phonegap.showcase.client.geolocation.GeolocationPresenter;
import de.kurka.phonegap.showcase.client.network.NetworkDisplay;
import de.kurka.phonegap.showcase.client.network.NetworkPresenter;
import de.kurka.phonegap.showcase.client.notification.NotificationDisplay;
import de.kurka.phonegap.showcase.client.notification.NotificationPresenter;

public class ShowCaseEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				Window.alert("uncaught: " + e.getLocalizedMessage());

			}
		});

		final PhoneGap phoneGap = new PhoneGap();

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

		DevicePresenter devicePresenter = new DevicePresenter(new DeviceDisplay(), phoneGap);
		GeolocationPresenter geolocationPresenter = new GeolocationPresenter(new GeolocationDisplay(), phoneGap);
		NetworkPresenter networkPresenter = new NetworkPresenter(new NetworkDisplay(), phoneGap);
		NotificationPresenter notificationPresenter = new NotificationPresenter(new NotificationDisplay(), phoneGap);
		AboutPresenter aboutPresenter = new AboutPresenter(new AboutDisplay());

		MainPresenter mainPresenter = new MainPresenter(new MainDisplay(), new AccelerometerPresenter(new AccelerometerDisplay(), phoneGap), devicePresenter, geolocationPresenter, networkPresenter,
				notificationPresenter, aboutPresenter);

		RootPanel.get().add(mainPresenter.getDisplay().asWidget());

		mainPresenter.start();
	}

}
