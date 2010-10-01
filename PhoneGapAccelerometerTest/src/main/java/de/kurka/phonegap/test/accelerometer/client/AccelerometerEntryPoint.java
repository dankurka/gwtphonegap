package de.kurka.phonegap.test.accelerometer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.PhoneGapAvaibleEvent;
import de.kurka.phonegap.client.PhoneGapAvaibleHandler;
import de.kurka.phonegap.client.PhoneGapTimeoutEvent;
import de.kurka.phonegap.client.PhoneGapTimeoutHandler;
import de.kurka.phonegap.client.accelerometer.Acceleration;
import de.kurka.phonegap.client.accelerometer.AccelerationCallback;
import de.kurka.phonegap.client.accelerometer.AccelerationOptions;
import de.kurka.phonegap.client.accelerometer.AccelerometerWatcher;

public class AccelerometerEntryPoint implements EntryPoint {

	private AccelerometerWatcher watchAcceleration;

	public void onModuleLoad() {
		final PhoneGap phoneGap = new PhoneGap();

		phoneGap.addHandler(new PhoneGapAvaibleHandler() {

			@Override
			public void onPhoneGapAvaible(PhoneGapAvaibleEvent event) {
				startAccel(phoneGap);
			}

		});

		phoneGap.addHandler(new PhoneGapTimeoutHandler() {

			@Override
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				Window.alert("can not load phonegap");

			}
		});

		phoneGap.startPhoneGap();

	}

	private void startAccel(final PhoneGap phoneGap) {
		if (!phoneGap.getAccelerometer().isAvailable()) {
			Window.alert("accel is not available");
			return;
		}

		final AccelerometerDisplay accelerometerDisplay = new AccelerometerDisplay();
		RootPanel.get().add(accelerometerDisplay);

		final AccelerationOptions options = new AccelerationOptions();
		options.setFrequency(50);

		watchAcceleration = phoneGap.getAccelerometer().watchAcceleration(new AccelerometerCallbackImpl(accelerometerDisplay), options);

		accelerometerDisplay.getStartStopButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (watchAcceleration != null) {
					phoneGap.getAccelerometer().clearWatch(watchAcceleration);
					watchAcceleration = null;
				} else {
					watchAcceleration = phoneGap.getAccelerometer().watchAcceleration(new AccelerometerCallbackImpl(accelerometerDisplay), options);
				}

			}
		});

	}

	private class AccelerometerCallbackImpl implements AccelerationCallback {

		private final AccelerometerDisplay display;

		public AccelerometerCallbackImpl(AccelerometerDisplay display) {
			this.display = display;

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
