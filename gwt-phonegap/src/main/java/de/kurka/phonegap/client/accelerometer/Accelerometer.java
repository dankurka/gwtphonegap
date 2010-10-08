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
public class Accelerometer {

	/**
	 * is the accelerometer module available
	 * @return true if it is available
	 */
	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.accelerometer) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	/**
	 * Get the current acceleration along the x, y, and z axis.
	 * 
	 * The accelerometer is a motion sensor that detects the change (delta) in movement relative to the current position. The accelerometer can detect 3D movement along the x, y, and z axis.
	 * The acceleration is returned using the accelerometerSuccess callback function.
	 * 
	 * <h1>iPhone Quirks</h1>
	 * <ul>
	 * 		<li>Phone doesn't have the concept of getting the current acceleration at any given point.</li>
	 * 		<li>You must watch the acceleration and capture the data at given time intervals.</li>
	 * 		<li>Thus, the getCurrentAcceleration function will give you the last value reported from a phoneGap watchAccelerometer call.</li>
	 * </ul>
	 * 
	 * @param accelerationCallback
	 * @param options
	 */
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

	/**
	 * At a regular interval, get the acceleration along the x, y, and z axis.
	 * 
	 * <h1>Description</h1>
	 * 
	 * <p>The accelerometer is a motion sensor that detects the change (delta) in movement relative to the current position. The accelerometer can detect 3D movement along the x, y, and z axis.</p>
	 * 
	 * <p>The accelerometer.watchAcceleration gets the device's current acceleration at a regular interval. Each time the Acceleration is retrieved, the accelerometerSuccess callback function is executed. Specify the interval in milliseconds via the frequency parameter in the acceleratorOptions object.</p>
	 * 
	 * <p>The returned watch ID references references the accelerometer watch interval. The watch ID can be used with accelerometer.clearWatch to stop watching the accelerometer.<p/>
	 * 
	 * 
	 * <h1>Supported Platforms</h1>
	 * <ul> 
	 * 	<li>Android</li>
	 * 	<li>iPhone</li>
	 * </ul>
	 * 
	 * <h1>iPhone Quirks</h1>
	 * <ul>
	 * 	<li>At the interval requested, PhoneGap will call the success callback function and pass the accelerometer results.</li>
	 * 	<li>However, in requests to the device PhoneGap restricts the interval to minimum of every 40ms and a maximum of every 1000ms.
	 * 		<ul><li>For example, if you request an interval of 3 seconds (3000ms), PhoneGap will request an interval of 1 second from the device but invoke the success callback at the requested interval of 3 seconds.</li></ul></li>
	 * 
	 * </ul>
	 * 
	 * @param options
	 * @param accelerationCallback
	 * @return
	 */
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

	/**
	 * Stop watching the Acceleration referenced by the watch ID parameter.
	 * 
	 * <h1>Supported Platforms</h1>
	 * <ul> 
	 * 	<li>Android</li>
	 * 	<li>iPhone</li>
	 * </ul>
	 * 
	 * @param watcher The Object returned by accelerometer.watchAcceleration.
	 * 
	 */
	public native void clearWatch(AccelerometerWatcher watcher) /*-{
		$wnd.navigator.accelerometer.clearWatch(watcher);
	}-*/;
}
