package de.kurka.phonegap.client.geolocation;

import com.google.gwt.core.client.JavaScriptObject;

public final class PositionError extends JavaScriptObject {

	public static final int PERMISSION_DENIED = 0;
	public static final int POSITION_UNAVAILABLE = 1;
	public static final int TIMEOUT = 2;

	protected PositionError() {

	}

	public native int getCode()/*-{
		return this.code;
	}-*/;

	public native String getMessage()/*-{
		return this.message;
	}-*/;

}
