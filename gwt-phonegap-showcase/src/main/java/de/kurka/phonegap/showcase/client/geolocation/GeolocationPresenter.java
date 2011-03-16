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
package de.kurka.phonegap.showcase.client.geolocation;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.geolocation.GeolocationCallback;
import de.kurka.phonegap.client.geolocation.GeolocationOptions;
import de.kurka.phonegap.client.geolocation.GeolocationWatcher;
import de.kurka.phonegap.client.geolocation.Position;
import de.kurka.phonegap.client.geolocation.PositionError;

public class GeolocationPresenter {

	private final PhoneGap phoneGap;
	private final Display display;

	private GeolocationWatcher watcher;
	private boolean running = false;

	public GeolocationPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();
	}

	private void bind() {
		display.setButtonText("Start");

		display.getStartStopButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (!running) {
					GeolocationOptions options = new GeolocationOptions();
					options.setFrequency(1000);
					watcher = phoneGap.getGeolocation().watchPosition(options, new GeoLocationCallbackImpl());
					display.setButtonText("Stop");
					running = true;
				} else {
					phoneGap.getGeolocation().clearWatch(watcher);
					watcher = null;
					display.setButtonText("Start");
					running = false;
				}

			}
		});

	}

	private native String getKeys(JavaScriptObject obj)/*-{
		var keys = "";
		for ( var key in obj) {
			keys += key + ";";
		}
		return keys;
	}-*/;

	private class GeoLocationCallbackImpl implements GeolocationCallback {

		@Override
		public void onSuccess(Position position) {
			display.setHorizontalAccuracy(position.getCoordinates().getHorizontalAccuracy());
			display.setVerticalAccuracy(position.getCoordinates().getVerticalAccuracy());

			display.setAltitude(position.getCoordinates().getAltitude());
			display.setAltitudeAccuracy(position.getCoordinates().getAltitudeAccuracy());
			display.setHeading(position.getCoordinates().getHeading());
			display.setLatitude(position.getCoordinates().getLatitude());
			display.setLongitude(position.getCoordinates().getLongitude());
			display.setSpeed(position.getCoordinates().getSpeed());

			display.setTime("" + position.getTimeStamp());

		}

		@Override
		public void onFailure(PositionError error) {
			switch (error.getCode()) {
			case PositionError.PERMISSION_DENIED:
				Window.alert("no permission - stoping watcher");

				break;
			case PositionError.POSITION_UNAVAILABLE:
				Window.alert("Position unavaible");
				break;
			case PositionError.TIMEOUT:
				Window.alert("timeout");
				break;
			default:
				break;
			}

			if (running) {
				phoneGap.getGeolocation().clearWatch(watcher);
				watcher = null;
				display.setButtonText("Start");
				running = false;

			}

		}

	}

	public interface Display {
		public Widget asWidget();

		public void setVerticalAccuracy(double verticalAccuracy);

		public void setHorizontalAccuracy(double horizontalAccuracy);

		public void setButtonText(String string);

		public void setSpeed(double speed);

		public void setLongitude(double longitude);

		public void setLatitude(double latitude);

		public void setHeading(double heading);

		public void setAltitudeAccuracy(double altitudeAccuracy);

		public void setAltitude(double altitude);

		public void setTime(String time);

		public HasClickHandlers getStartStopButton();
	}

	public Display getDisplay() {
		return display;
	}
}
