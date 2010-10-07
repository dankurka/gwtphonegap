package de.kurka.phonegap.showcase.client;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.accelerometer.AccelerometerPresenter;
import de.kurka.phonegap.showcase.client.device.DevicePresenter;
import de.kurka.phonegap.showcase.client.geolocation.GeolocationPresenter;
import de.kurka.phonegap.showcase.client.network.NetworkPresenter;
import de.kurka.phonegap.showcase.client.notification.NotificationPresenter;

public class MainPresenter {

	private final MainDisplay display;
	private final AccelerometerPresenter accelerometerPresenter;
	private final DevicePresenter devicePresenter;
	private final GeolocationPresenter geolocationPresenter;
	private final NetworkPresenter networkPresenter;
	private final NotificationPresenter notificationPresenter;

	public MainPresenter(MainDisplay display, AccelerometerPresenter accelerometerPresenter, DevicePresenter devicePresenter, GeolocationPresenter geolocationPresenter,
			NetworkPresenter networkPresenter, NotificationPresenter notificationPresenter) {
		this.display = display;
		this.accelerometerPresenter = accelerometerPresenter;
		this.devicePresenter = devicePresenter;
		this.geolocationPresenter = geolocationPresenter;
		this.networkPresenter = networkPresenter;
		this.notificationPresenter = notificationPresenter;

	}

	public interface Display {
		public Widget asWidget();

		public HasWidgets getContainer();

	}

	public MainDisplay getDisplay() {
		return display;
	}

	public void start() {
		display.getContainer().add(accelerometerPresenter.getDisplay().asWidget());
		display.getContainer().add(devicePresenter.getDisplay().asWidget());
		display.getContainer().add(geolocationPresenter.getDisplay().asWidget());
		display.getContainer().add(networkPresenter.getDisplay().asWidget());
		display.getContainer().add(notificationPresenter.getDisplay().asWidget());
	}
}
