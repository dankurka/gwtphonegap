package de.kurka.phonegap.client;

import de.kurka.phonegap.client.device.Device;

/**
 * This class is a wrapper class for phonegap.js
 * 
 * @author Daniel Kurka
 * 
 */
public class PhoneGap {

	private Device device;

	public PhoneGap() {
		device = new Device();
	}

	/**
	 * 
	 * @return the device object containing device specific information
	 */
	public Device getDevice() {
		return device;
	}
}
