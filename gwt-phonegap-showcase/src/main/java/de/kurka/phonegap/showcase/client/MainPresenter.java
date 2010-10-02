package de.kurka.phonegap.showcase.client;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.showcase.client.accelerometer.AccelerometerPresenter;
import de.kurka.phonegap.showcase.client.device.DevicePresenter;

public class MainPresenter {

	private final MainDisplay display;
	private final AccelerometerPresenter accelerometerPresenter;
	private final DevicePresenter devicePresenter;

	public MainPresenter(MainDisplay display, AccelerometerPresenter accelerometerPresenter, DevicePresenter devicePresenter) {
		this.display = display;
		this.accelerometerPresenter = accelerometerPresenter;
		this.devicePresenter = devicePresenter;

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
	}
}
