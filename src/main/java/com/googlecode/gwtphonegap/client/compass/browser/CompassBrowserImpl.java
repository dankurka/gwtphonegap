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
package com.googlecode.gwtphonegap.client.compass.browser;

import java.util.List;

import com.google.gwt.user.client.Timer;
import com.googlecode.gwtphonegap.client.compass.CompassCallback;
import com.googlecode.gwtphonegap.client.compass.CompassMock;
import com.googlecode.gwtphonegap.client.compass.CompassOptions;
import com.googlecode.gwtphonegap.client.compass.CompassWatcher;

public class CompassBrowserImpl implements CompassMock {

	private List<Double> values;
	private int currentIndex;
	private int maxIndex;

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

	@Override
	public void setMockValues(List<Double> values) {
		this.values = values;
		if (this.values != null) {
			if (this.values.size() < 1) {
				this.values = null;
				throw new IllegalArgumentException("list can't be empty");
			}
			currentIndex = 0;
			maxIndex = values.size();
		}

	}

	public class CompassWatcherTimerImpl extends Timer implements CompassWatcher {

		private final CompassCallback callback;

		public CompassWatcherTimerImpl(CompassCallback callback) {
			this.callback = callback;

		}

		@Override
		public void run() {
			if (shouldFail) {
				callback.onError();
			} else {
				if (values == null) {
					callback.onSuccess(new CompassHeadingMockValue(0, -1, 0));
				} else {
					Double heading = values.get(currentIndex);
					currentIndex++;
					currentIndex = currentIndex % maxIndex;
					callback.onSuccess(new CompassHeadingMockValue(heading, heading, 1));

				}
			}

		}

	}

	private boolean shouldFail;

	@Override
	public void setShouldFail(boolean shouldFail) {
		this.shouldFail = shouldFail;

	}

}
