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
package de.kurka.phonegap.client.geolocation;

import com.google.gwt.user.client.Timer;

public class GeolocationBrowserEmptyImpl implements Geolocation {

	@Override
	public void getCurrentPosition(GeolocationCallback callback) {
		callback.onFailure(new PostionErrorJavaImpl(PositionError.PERMISSION_DENIED, ""));

	}

	@Override
	public GeolocationWatcher watchPosition(GeolocationOptions options, GeolocationCallback callback) {
		return new GeolocationWatcherGwtTimerImpl(options, callback);
	}

	@Override
	public void clearWatch(GeolocationWatcher watcher) {
		if (!(watcher instanceof GeolocationWatcherGwtTimerImpl)) {
			throw new IllegalArgumentException();
		}
		GeolocationWatcherGwtTimerImpl timerImpl = (GeolocationWatcherGwtTimerImpl) watcher;
		timerImpl.cancel();

	}

	private class GeolocationWatcherGwtTimerImpl extends Timer implements GeolocationWatcher {

		private final GeolocationCallback callback;
		private final GeolocationOptions options;

		public GeolocationWatcherGwtTimerImpl(GeolocationOptions options, GeolocationCallback callback) {

			this.callback = callback;
			this.options = options;
			schedule((int) options.getFrequency());
		}

		@Override
		public void run() {

			schedule((int) options.getFrequency());

			callback.onFailure(new PostionErrorJavaImpl(PositionError.PERMISSION_DENIED, ""));

		}

	}

}
