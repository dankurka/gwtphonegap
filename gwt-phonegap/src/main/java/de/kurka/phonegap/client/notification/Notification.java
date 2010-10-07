package de.kurka.phonegap.client.notification;

public class Notification {

	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.navigator.notification) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	public void alert(String message) {
		alert(message, "Alert", "Ok");
	}

	public void alert(String message, String title) {
		alert(message, title, "Ok");
	}

	public native void alert(String message, String title, String buttonName)/*-{
		$wnd.navigator.notification.alert(message, title, buttonName);
	}-*/;

	public native void beep(int count)/*-{
		$wnd.navigator.notification.beep(count);
	}-*/;

	public native void vibrate(int milliseconds)/*-{
		$wnd.navigator.notification.vibrate(milliseconds);
	}-*/;
}
