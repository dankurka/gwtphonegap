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
package de.kurka.phonegap.client.accelerometer.js;

import de.kurka.phonegap.client.accelerometer.AccelerationCallback;
import de.kurka.phonegap.client.accelerometer.AccelerationOptions;
import de.kurka.phonegap.client.accelerometer.Accelerometer;
import de.kurka.phonegap.client.accelerometer.AccelerometerWatcher;

/**
 * Captures device motion in the x, y, and z direction.
 * 
 * @author Daniel Kurka
 * 
 */
public class AccelerometerMobileImpl implements Accelerometer {

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Accelerometer#getCurrentAcceleration(de.kurka.phonegap.client.accelerometer.AccelerationCallback, de.kurka.phonegap.client.accelerometer.AccelerationOptions)
	 */
	@Override
	public native void getCurrentAcceleration(AccelerationCallback accelerationCallback, AccelerationOptions options) /*-{
		var successCallback = function(data) {
			accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onSuccess(Lde/kurka/phonegap/client/accelerometer/Acceleration;)(data);
		};

		var errorCallback = function() {
			accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onFailure()();
		};

		var freq = options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()();

		var localOptions = {
			frequency : freq
		}

		$wnd.navigator.accelerometer.getCurrentAcceleration(
				$entry(successCallback), $entry(errorCallback), localOptions);
	}-*/;

	@Override
	public AccelerometerWatcher watchAcceleration(AccelerationOptions options, AccelerationCallback accelerationCallback) {
		String id = watchAcceleration0(options, accelerationCallback);

		return new AccelerometerWatcherJsImpl(id);
	}

	private native String watchAcceleration0(AccelerationOptions options, AccelerationCallback accelerationCallback) /*-{
		var sc = function(data) {
			accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onSuccess(Lde/kurka/phonegap/client/accelerometer/Acceleration;)(data);
		};

		var ec = function() {
			accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onFailure()();
		};

		var freq = options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()();

		var localOptions = {
			frequency : freq
		};

		var idv = $wnd.navigator.accelerometer.watchAcceleration($entry(sc),
				$entry(ec), localOptions);

		return idv;

	}-*/;

	@Override
	public void clearWatch(AccelerometerWatcher watcher) {
		if (!(watcher instanceof AccelerometerWatcherJsImpl)) {
			throw new IllegalStateException("this should not happen - can only clear Watchers you got from watchAcceleration");
		}
		AccelerometerWatcherJsImpl watcherImpl = (AccelerometerWatcherJsImpl) watcher;
		clearWatch0(watcherImpl.getId());

	}

	private native void clearWatch0(String id) /*-{
		$wnd.navigator.accelerometer.clearWatch(id);
	}-*/;
}
