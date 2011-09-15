package de.kurka.phonegap.client.compass.browser;

import com.google.gwt.user.client.Timer;

import de.kurka.phonegap.client.compass.CompassCallback;
import de.kurka.phonegap.client.compass.CompassWatcher;

public class CompassWatcherTimerImpl extends Timer implements CompassWatcher {

	private final CompassCallback callback;

	public CompassWatcherTimerImpl(CompassCallback callback) {
		this.callback = callback;

	}

	@Override
	public void run() {
		callback.onError();
	}

}
