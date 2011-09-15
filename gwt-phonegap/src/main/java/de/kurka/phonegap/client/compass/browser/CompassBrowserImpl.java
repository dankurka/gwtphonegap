package de.kurka.phonegap.client.compass.browser;

import de.kurka.phonegap.client.compass.Compass;
import de.kurka.phonegap.client.compass.CompassCallback;
import de.kurka.phonegap.client.compass.CompassOptions;
import de.kurka.phonegap.client.compass.CompassWatcher;

public class CompassBrowserImpl implements Compass {

	@Override
	public void getCurrentHeading(CompassOptions options, CompassCallback callback) {
		callback.onError();

	}

	@Override
	public CompassWatcher watchHeading(CompassOptions options, CompassCallback callback) {
		CompassWatcherTimerImpl watcher = new CompassWatcherTimerImpl(callback);
		watcher.scheduleRepeating(options.getFrequency());
		return watcher;
	}

	@Override
	public void clearWatcher(CompassWatcher watcher) {
		if (!(watcher instanceof CompassWatcherTimerImpl)) {
			throw new IllegalStateException("should not happen can only cancel watchers you got from watchHeading");
		}
		CompassWatcherTimerImpl timerImpl = (CompassWatcherTimerImpl) watcher;
		timerImpl.cancel();
	}

}
