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
package de.kurka.phonegap.showcase.client.accelerometer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.accelerometer.Acceleration;
import de.kurka.phonegap.client.accelerometer.AccelerationCallback;
import de.kurka.phonegap.client.accelerometer.AccelerationOptions;
import de.kurka.phonegap.client.accelerometer.AccelerometerWatcher;

public class AccelerometerPresenter {

	private final Display display;
	private final PhoneGap phoneGap;

	private AccelerometerWatcher watcher = null;

	public AccelerometerPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;
		bind();
	}

	public interface Display {
		public Widget asWidget();

		public HasClickHandlers getStartStopButton();

		public void setXValue(String string);

		public void setYValue(String string);

		public void setZValue(String string);
	}

	public Display getDisplay() {
		return display;

	}

	private void bind() {
		display.getStartStopButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (watcher == null) {
					final AccelerationOptions options = new AccelerationOptions();
					options.setFrequency(50);
					watcher = phoneGap.getAccelerometer().watchAcceleration(options, new AccelerometerCallbackImpl());
				} else {
					phoneGap.getAccelerometer().clearWatch(watcher);
					watcher = null;
				}
			}
		});
	}

	private class AccelerometerCallbackImpl implements AccelerationCallback {

		public AccelerometerCallbackImpl() {

		}

		@Override
		public void onSuccess(Acceleration acceleration) {
			display.setXValue("" + acceleration.getX());
			display.setYValue("" + acceleration.getY());
			display.setZValue("" + acceleration.getZ());

		}

		@Override
		public void onFailure() {
			Window.alert("failure while reading accel");

		}

	}

}
