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
package de.kurka.phonegap.client.accelerometer;

/**
 * Captures device motion in the x, y, and z direction.
 * @author Daniel Kurka
 *
 */
public class AccelerometerMobileImpl implements Accelerometer {

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Accelerometer#isAvailable()
	 */
	@Override
	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.accelerometer) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Accelerometer#getCurrentAcceleration(de.kurka.phonegap.client.accelerometer.AccelerationCallback, de.kurka.phonegap.client.accelerometer.AccelerationOptions)
	 */
	@Override
	public native void getCurrentAcceleration(AccelerationCallback accelerationCallback, AccelerationOptions options) /*-{
		var successCallback = function(data){
		$entry(accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onSuccess(Lde/kurka/phonegap/client/accelerometer/Acceleration;)(data));
		};

		var errorCallback = function(){
		$entry(accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onFailure()());
		};

		var freq = options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()();

		var localOptions = {
		frequency: freq
		}

		$wnd.navigator.accelerometer.getCurrentAcceleration(successCallback, errorCallback, localOptions);
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Accelerometer#watchAcceleration(de.kurka.phonegap.client.accelerometer.AccelerationOptions, de.kurka.phonegap.client.accelerometer.AccelerationCallback)
	 */
	@Override
	public native AccelerometerWatcher watchAcceleration(AccelerationOptions options, AccelerationCallback accelerationCallback) /*-{
		var sc = function(data){
		accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onSuccess(Lde/kurka/phonegap/client/accelerometer/Acceleration;)(data);
		};

		var ec = function(){
		accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onFailure()();
		};

		var freq = options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()();

		var localOptions = {
		frequency: freq
		}

		return $wnd.navigator.accelerometer.watchAcceleration(sc, ec, localOptions);
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Accelerometer#clearWatch(de.kurka.phonegap.client.accelerometer.AccelerometerWatcher)
	 */
	@Override
	public native void clearWatch(AccelerometerWatcher watcher) /*-{
		$wnd.navigator.accelerometer.clearWatch(watcher);
	}-*/;
}
