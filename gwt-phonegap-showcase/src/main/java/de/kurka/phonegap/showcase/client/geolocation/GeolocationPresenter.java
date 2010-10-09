package de.kurka.phonegap.showcase.client.geolocation;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import de.kurka.phonegap.client.PhoneGap;
import de.kurka.phonegap.client.geolocation.GeolocationCallback;
import de.kurka.phonegap.client.geolocation.GeolocationOptions;
import de.kurka.phonegap.client.geolocation.GeolocationWatcher;
import de.kurka.phonegap.client.geolocation.Position;
import de.kurka.phonegap.client.geolocation.PositionError;

public class GeolocationPresenter {

	private final PhoneGap phoneGap;
	private final Display display;

	private GeolocationWatcher watcher;

	public GeolocationPresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		bind();
	}

	private void bind() {
		display.setButtonText("Start");

		display.getStartStopButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (watcher == null) {
					GeolocationOptions options = new GeolocationOptions();
					options.setFrequency(1000);
					watcher = phoneGap.getGeolocation().watchPosition(options, new GeoLocationCallbackImpl());
					display.setButtonText("Stop");
				} else {
					phoneGap.getGeolocation().clearWatch(watcher);
					watcher = null;
					display.setButtonText("Start");
				}

			}
		});

	}

	private native String getKeys(JavaScriptObject obj)/*-{
		var keys = "";
		for(var key in obj){
		keys += key + ";";
		}
		return keys;
	}-*/;

	private class GeoLocationCallbackImpl implements GeolocationCallback {

		@Override
		public void onSuccess(Position position) {
			display.setHorizontalAccuracy(position.getCoordinates().getHorizontalAccuracy());
			display.setVerticalAccuracy(position.getCoordinates().getVerticalAccuracy());

			display.setAltitude(position.getCoordinates().getAltitude());
			display.setAltitudeAccuracy(position.getCoordinates().getAltitudeAccuracy());
			display.setHeading(position.getCoordinates().getHeading());
			display.setLatitude(position.getCoordinates().getLatitude());
			display.setLongitude(position.getCoordinates().getLongitude());
			display.setSpeed(position.getCoordinates().getSpeed());

			display.setTime("" + position.getTimeStamp());

		}

		@Override
		public void onFailure(PositionError error) {
			switch (error.getCode()) {
			case PositionError.PERMISSION_DENIED:
				Window.alert("no permission - stoping watcher");

				break;
			case PositionError.POSITION_UNAVAILABLE:
				Window.alert("Position unavaible");
				break;
			case PositionError.TIMEOUT:
				Window.alert("timeout");
				break;
			default:
				break;
			}

			if (watcher != null) {
				phoneGap.getGeolocation().clearWatch(watcher);
				watcher = null;
				display.setButtonText("Start");
			}

		}

	}

	public interface Display {
		public Widget asWidget();

		public void setVerticalAccuracy(double verticalAccuracy);

		public void setHorizontalAccuracy(double horizontalAccuracy);

		public void setButtonText(String string);

		public void setSpeed(double speed);

		public void setLongitude(double longitude);

		public void setLatitude(double latitude);

		public void setHeading(double heading);

		public void setAltitudeAccuracy(double altitudeAccuracy);

		public void setAltitude(double altitude);

		public void setTime(String time);

		public HasClickHandlers getStartStopButton();
	}

	public Display getDisplay() {
		return display;
	}
}
