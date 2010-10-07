package de.kurka.phonegap.client;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.Timer;

import de.kurka.phonegap.client.accelerometer.Accelerometer;
import de.kurka.phonegap.client.camera.Camera;
import de.kurka.phonegap.client.device.Device;
import de.kurka.phonegap.client.geolocation.Geolocation;
import de.kurka.phonegap.client.log.DebugLogger;
import de.kurka.phonegap.client.network.Network;
import de.kurka.phonegap.client.notification.Notification;

/**
 * This class is a wrapper class for phonegap.js
 * 
 * @author Daniel Kurka
 * 
 */
public class PhoneGap {

	private Device device;

	private Accelerometer accelerometer;
	private Camera camera;
	private Geolocation geolocation;
	private Network network;
	private Notification notification;
	private DebugLogger debugLogger;

	private HandlerManager handlerManager = new HandlerManager(null);

	public PhoneGap() {

	}

	public native boolean isPhoneGapReady()/*-{
		if(typeof($wnd.PhoneGap) == "undefined"){
		return false;
		}else{
		return $wnd.PhoneGap.available;
		}
	}-*/;

	public void startPhoneGap(final int timeoutInMs) {
		final long end = System.currentTimeMillis() + timeoutInMs;
		if (isPhoneGapReady()) {

			DeferredCommand.addCommand(new Command() {

				@Override
				public void execute() {
					firePhoneGapAvaible();
				}

			});

		} else {
			Timer timer = new Timer() {

				@Override
				public void run() {
					if (isPhoneGapReady()) {
						firePhoneGapAvaible();
						return;
					}

					if (System.currentTimeMillis() - end > 0) {
						handlerManager.fireEvent(new PhoneGapTimeoutEvent());
					} else {
						schedule(10);
					}

				}
			};

			timer.schedule(10);
		}
	}

	private void firePhoneGapAvaible() {
		constructModules();

		handlerManager.fireEvent(new PhoneGapAvaibleEvent());
	}

	private void constructModules() {
		device = new Device();
		accelerometer = new Accelerometer();
		camera = new Camera();
		geolocation = new Geolocation();
		network = new Network();
		notification = new Notification();
		debugLogger = new DebugLogger();

	}

	public void startPhoneGap() {
		startPhoneGap(10000);
	}

	public HandlerRegistration addHandler(PhoneGapAvaibleHandler handler) {
		return handlerManager.addHandler(PhoneGapAvaibleEvent.TYPE, handler);
	}

	public HandlerRegistration addHandler(PhoneGapTimeoutHandler handler) {
		return handlerManager.addHandler(PhoneGapTimeoutEvent.TYPE, handler);
	}

	/**
	 * 
	 * @return the device object containing device specific information
	 */
	public Device getDevice() {
		return device;
	}

	public Accelerometer getAccelerometer() {
		return accelerometer;
	}

	public Camera getCamera() {
		return camera;
	}

	public Geolocation getGeolocation() {
		return geolocation;
	}

	public Network getNetwork() {
		return network;
	}

	public Notification getNotification() {
		return notification;
	}

	public DebugLogger getDebugLogger() {
		return debugLogger;
	}
}
