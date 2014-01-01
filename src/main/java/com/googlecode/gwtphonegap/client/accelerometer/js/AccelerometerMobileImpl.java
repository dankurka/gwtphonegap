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
package com.googlecode.gwtphonegap.client.accelerometer.js;

import com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerationOptions;
import com.googlecode.gwtphonegap.client.accelerometer.Accelerometer;
import com.googlecode.gwtphonegap.client.accelerometer.AccelerometerWatcher;

/**
 * Captures device motion in the x, y, and z direction.
 * 
 * @author Daniel Kurka
 * 
 */
public class AccelerometerMobileImpl implements Accelerometer {

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.accelerometer.Accelerometer#getCurrentAcceleration(com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback)
	 */
	@Override
	public native void getCurrentAcceleration(AccelerationCallback accelerationCallback) /*-{
		var successCallback = function(data) {
			accelerationCallback.@com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/accelerometer/Acceleration;)(data);
		};

		var errorCallback = function() {
			accelerationCallback.@com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback::onFailure()();
		};

		$wnd.navigator.accelerometer.getCurrentAcceleration(
				$entry(successCallback), $entry(errorCallback));
	}-*/;

	@Override
	public AccelerometerWatcher watchAcceleration(AccelerationOptions options, AccelerationCallback accelerationCallback) {
		String id = watchAcceleration0(options, accelerationCallback);

		return new AccelerometerWatcherJsImpl(id);
	}

	private native String watchAcceleration0(AccelerationOptions options, AccelerationCallback accelerationCallback) /*-{
		var sc = function(data) {
			accelerationCallback.@com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/accelerometer/Acceleration;)(data);
		};

		var ec = function() {
			accelerationCallback.@com.googlecode.gwtphonegap.client.accelerometer.AccelerationCallback::onFailure()();
		};

		var freq = options.@com.googlecode.gwtphonegap.client.accelerometer.AccelerationOptions::getFrequency()();

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
