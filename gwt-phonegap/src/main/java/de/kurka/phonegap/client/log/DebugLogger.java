package de.kurka.phonegap.client.log;

/**
 * 
 * This class provides access to the debugging console.
 * 
 * 
 * @author Daniel Kurka
 *
 */
public class DebugLogger {

	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.debug) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	public static native void info(String message) /*-{
		$wnd.debug.log(message);
	}-*/;

	public static native void warn(String message) /*-{
		$wnd.debug.warn(message);
	}-*/;

	public static native void error(String message) /*-{
		$wnd.debug.error(message);
	}-*/;
}
