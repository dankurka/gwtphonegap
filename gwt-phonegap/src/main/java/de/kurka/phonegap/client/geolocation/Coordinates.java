package de.kurka.phonegap.client.geolocation;

import com.google.gwt.core.client.JavaScriptObject;

public final class Coordinates extends JavaScriptObject {
	protected Coordinates() {

	}

	public native double getLatitude()/*-{
		return this.latitude;
	}-*/;

	public native double getLongitude()/*-{
		return this.longitude;
	}-*/;

	public native double getAltitude()/*-{
		return this.altitude;
	}-*/;

	public native double getHorizontalAccuracy()/*-{
		return this.accuracy.horizontal;
	}-*/;

	public native double getVerticalAccuracy()/*-{
		return this.accuracy.vertical;
	}-*/;

	public native double getAltitudeAccuracy()/*-{
		return this.altitudeAccuracy;
	}-*/;

	public native double getHeading()/*-{
		return this.heading;
	}-*/;

	public native double getSpeed()/*-{
		return this.speed;
	}-*/;

}
