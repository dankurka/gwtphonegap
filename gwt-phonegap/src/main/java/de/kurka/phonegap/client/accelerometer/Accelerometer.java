package de.kurka.phonegap.client.accelerometer;

public class Accelerometer {

	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.accelerometer) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	public native void getCurrentAcceleration(AccelerationCallback accelerationCallback, AccelerationOptions options) /*-{
		var successCallback = function(data){
		accelerationCallback.@de.kurka.phonegap.client.accelerometer.AccelerationCallback::onSuccess(Lde/kurka/phonegap/client/accelerometer/Acceleration;)(data);
		};

		var errorCallback = function(){
		accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onFailure()();
		};

		var freq = options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()();

		var localOptions = {
		frequency: freq
		}

		$wnd.navigator.accelerometer.getCurrentAcceleration(successCallback, errorCallback, localOptions);
	}-*/;

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

	public native void clearWatch(AccelerometerWatcher watcher) /*-{
		$wnd.navigator.accelerometer.clearWatch(watcher);
	}-*/;
}
