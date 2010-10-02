package de.kurka.phonegap.client.geolocation;

/**
 * 
 * Geolocation provides location information for the device, such as latitude and longitude. Common sources of location information include Global Positioning System (GPS) and location inferred from network signals such as IP address, RFID, WiFi and Bluetooth MAC addresses, and GSM/CDMA cell IDs. No guarantee is given that the API returns the device's actual location.
 * 
 * This API is based on the W3C Geo location API Specification. Some devices already provide an implementation of this spec. For those devices, the built-in support is used instead of replacing it with PhoneGap's implementation. For devices that don't have geolocation support, PhoneGap's implementation should be compatible with the W3C specification.
 * 
 * @author Daniel Kurka
 *
 */
public class Geolocation {

	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.geolocation) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	/**
	 * calculates the device's current position as a Position object.
	 * 
	 * Function geolocation.getCurrentPositon is an asynchronous function. It returns the device's current position to the geolocationSuccess callback with a Position object as the parameter. If there is an error, the geolocationError callback is invoked with a PositionError object.
	 * 
	 * @param options
	 * @param callback
	 */
	public native void getCurrentPosition(GeolocationCallback callback)/*-{
		var successCallback = function(data){
		callback.@de.kurka.phonegap.client.geolocation.GeolocationCallback::onSuccess(Lde/kurka/phonegap/client/geolocation/Position;)(data);
		};

		var errorCallback = function(){
		callback.@de.kurka.phonegap.client.geolocation.GeolocationCallback::onFailure()();
		};

		$wnd.navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
	}-*/;

}
