package de.kurka.phonegap.showcase.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.PhoneGapAvaibleEvent;
import de.kurka.phonegap.client.PhoneGapAvaibleHandler;
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

public class ShowCaseEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		final PhoneGap phoneGap = new PhoneGap();

		phoneGap.addHandler(new PhoneGapAvaibleHandler() {

			@Override
			public void onPhoneGapAvaible(PhoneGapAvaibleEvent event) {
				startShowCase(phoneGap);
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

	private void startShowCase(PhoneGap phoneGap) {

		DevicePresenter devicePresenter = new DevicePresenter(new DeviceDisplay(), phoneGap);
		GeolocationPresenter geolocationPresenter = new GeolocationPresenter(new GeolocationDisplay(), phoneGap);
		NetworkPresenter networkPresenter = new NetworkPresenter(new NetworkDisplay(), phoneGap);

		MainPresenter mainPresenter = new MainPresenter(new MainDisplay(), new AccelerometerPresenter(new AccelerometerDisplay(), phoneGap), devicePresenter, geolocationPresenter, networkPresenter);

		RootPanel.get().add(mainPresenter.getDisplay().asWidget());

		mainPresenter.start();
	}

}
