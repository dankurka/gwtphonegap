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
package com.googlecode.gwtphonegap.client.accelerometer.browser;

import java.util.List;

import com.google.gwt.user.client.Timer;
import com.googlecode.gwtphonegap.client.accelerometer.Acceleration;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationOptions;
import com.googlecode.gwtphonegap.client.accelerometer.AccelermeterMock;
import com.googlecode.gwtphonegap.client.accelerometer.Accelerometer;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerometerWatcher;


public class AccelerometerBrowserImpl implements Accelerometer, AccelermeterMock {

	@Override
	public void getCurrentAcceleration(AccelerationCallback accelerationCallback) {
		accelerationCallback.onSuccess(new AccelerationBrowserImpl(0, 0, 0));
	}

	@Override
	public AccelerometerWatcher watchAcceleration(final AccelerationOptions options, AccelerationCallback accelerationCallback) {
		return new AccelerometerWatcherGwtTimerImpl(options, accelerationCallback);
	}

	@Override
	public void clearWatch(AccelerometerWatcher watcher) {
		if (!(watcher instanceof AccelerometerWatcherGwtTimerImpl)) {
			throw new IllegalArgumentException("This object was not created by this implementation");
		}
		AccelerometerWatcherGwtTimerImpl accelerometerWatcherGwtTimerImpl = (AccelerometerWatcherGwtTimerImpl) watcher;
		accelerometerWatcherGwtTimerImpl.cancel();

	}

	private class AccelerometerWatcherGwtTimerImpl extends Timer implements AccelerometerWatcher {

		private final AccelerationCallback callback;
		private final AccelerationOptions options;

		public AccelerometerWatcherGwtTimerImpl(AccelerationOptions options, AccelerationCallback callback) {
			this.options = options;
			this.callback = callback;
			schedule((int) options.getFrequency());
		}

		@Override
		public void run() {

			schedule((int) options.getFrequency());

			if (shouldFail) {
				callback.onFailure();
			} else {

				if (useMockValues) {
					Acceleration impl = mockValues.get(currentIndex);
					currentIndex++;
					currentIndex = currentIndex % maxIndex;
					callback.onSuccess(impl);
				} else {
					callback.onSuccess(new AccelerationBrowserImpl(0, 0, 0));
				}
			}

		}

	}

	private List<Acceleration> mockValues;
	private int currentIndex;
	private int maxIndex;
	private boolean useMockValues;

	private boolean shouldFail;

	@Override
	public void setMockValues(List<Acceleration> values) {
		if (values == null) {
			mockValues = null;
			useMockValues = false;
		} else {
			if (values.size() == 0) {
				throw new IllegalArgumentException("no values provided");
			}
			this.mockValues = values;
			this.currentIndex = 0;
			this.maxIndex = mockValues.size();
			useMockValues = true;

		}

	}

	public void setShouldFail(boolean shouldFail) {
		this.shouldFail = shouldFail;
	}

}
