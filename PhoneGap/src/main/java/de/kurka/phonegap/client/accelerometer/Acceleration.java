package de.kurka.phonegap.client.accelerometer;

import com.google.gwt.core.client.JavaScriptObject;

public final class Acceleration extends JavaScriptObject {

	protected Acceleration() {

	}

	/**
	 * The force applied by the device in the x-axis.
	 */
	public native double getX()/*-{
		return this.x;
	}-*/;

	/**
	 * The force applied by the device in the y-axis.
	 */
	public native double getY()/*-{
		return this.y;
	}-*/;

	/**
	 * The force applied by the device in the z-axis.
	 */

	public native double getZ()/*-{
		return this.z;
	}-*/;

	public native double getTimeStamp()/*-{
		return this.timestamp;
	}-*/;

}
