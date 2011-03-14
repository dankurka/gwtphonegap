package de.kurka.phonegap.client;

import com.google.gwt.event.shared.HandlerRegistration;

import de.kurka.phonegap.client.accelerometer.Accelerometer;
import de.kurka.phonegap.client.camera.Camera;
import de.kurka.phonegap.client.device.Device;
import de.kurka.phonegap.client.geolocation.Geolocation;
import de.kurka.phonegap.client.log.DebugLogger;
import de.kurka.phonegap.client.network.Network;
import de.kurka.phonegap.client.notification.Notification;

public interface PhoneGap {

	/**
	 * Determine if phonegap is initialized
	 * @return true if phonegap is initialized
	 */
	public abstract boolean isPhoneGapInitialized();

	/**
	 * Initializes Phonegap with a default timeout see: {@link PhoneGapMobileImpl#initializePhoneGap(int)}
	 */
	public abstract void initializePhoneGap();

	/**
	 * initialize Phonegap 
	 * 
	 * If Phonegap is initialized successfully within timeout a {@link PhoneGapAvaibleEvent} is fired, else a {@link PhoneGapTimeoutEvent} is fired
	 * 
	 * @param timeoutInMs the timeout in milliseconds
	 */
	public abstract void initializePhoneGap(final int timeoutInMs);

	/**
	 * Add a handler for {@link PhoneGapAvaibleEvent}
	 * @param handler the handler to add
	 * @return the handler registration
	 */
	public abstract HandlerRegistration addHandler(
			PhoneGapAvailableHandler handler);

	/**
	 * Add a handler for {@link PhoneGapTimeoutEvent}
	 * @param handler the handler to add
	 * @return the handler registration
	 */
	public abstract HandlerRegistration addHandler(
			PhoneGapTimeoutHandler handler);

	/**
	 * get the phonegap device object
	 * @return the device object containing device specific information
	 */
	public abstract Device getDevice();

	/**
	 * get the phonegap accelerometer object
	 * @return
	 */
	public abstract Accelerometer getAccelerometer();

	/**
	 * get the phonegap camera object
	 * @return
	 */
	public abstract Camera getCamera();

	/**
	 * get the phonegap geolocation object
	 * @return
	 */
	public abstract Geolocation getGeolocation();

	/**
	 * get the phonegap network object
	 * @return
	 */
	public abstract Network getNetwork();

	/**
	 * get the phonegap notification object
	 * @return
	 */
	public abstract Notification getNotification();

	/**
	 * get the phonegap debuglogger object
	 * @return
	 */
	public abstract DebugLogger getDebugLogger();

}