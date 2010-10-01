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
		accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onSuccess()();
		};

		var errorCallback = function(){
		accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onFailure()();
		};

		var localOptions = {
		desiredFrequency:options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()
		}

		$wnd.navigator.accelerometer.getCurrentAcceleration(successCallback, errorCallback, localOptions);
	}-*/;

	public native AccelerometerWatcher watchAcceleration(AccelerationCallback accelerationCallback, AccelerationOptions options) /*-{
		var successCallback = function(data){
		accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onSuccess()();
		};

		var errorCallback = function(){
		accelerationCallback.@de.kurka.phonegap.client.file.DirectoryDeleteCallback::onFailure()();
		};

		var localOptions = {
		desiredFrequency:options.@de.kurka.phonegap.client.accelerometer.AccelerationOptions::getFrequency()
		}

		$wnd.navigator.accelerometer.watchAcceleration(successCallback, errorCallback, localOptions);
	}-*/;

	public native void clearWatch(AccelerometerWatcher watcher) /*-{
		$wnd.navigator.accelerometer.clearWatch(watcher);
	}-*/;
}
