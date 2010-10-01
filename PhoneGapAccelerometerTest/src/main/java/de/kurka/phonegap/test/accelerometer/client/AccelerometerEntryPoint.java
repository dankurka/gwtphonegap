package de.kurka.phonegap.test.accelerometer.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import de.kurka.phonegap.client.PhoneGap;

public class AccelerometerEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		PhoneGap phoneGap = new PhoneGap();

		Window.alert(phoneGap.getDevice().getUuid());
	}

}
