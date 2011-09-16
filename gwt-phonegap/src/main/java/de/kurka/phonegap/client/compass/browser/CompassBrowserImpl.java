/*
 * Copyright 2011 Daniel Kurka
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
