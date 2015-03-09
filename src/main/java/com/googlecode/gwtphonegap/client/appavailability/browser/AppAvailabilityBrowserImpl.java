package com.googlecode.gwtphonegap.client.appavailability.browser;

import com.googlecode.gwtphonegap.client.appavailability.AppAvailability;
import com.googlecode.gwtphonegap.client.appavailability.AppAvailabilityCallback;

public class AppAvailabilityBrowserImpl implements AppAvailability {
	@Override
	public void check(String identifier, AppAvailabilityCallback callback) {
		callback.onNotAvailable();
	}
}