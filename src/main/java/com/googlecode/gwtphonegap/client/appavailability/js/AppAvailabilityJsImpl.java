package com.googlecode.gwtphonegap.client.appavailability.js;

import com.googlecode.gwtphonegap.client.appavailability.AppAvailability;
import com.googlecode.gwtphonegap.client.appavailability.AppAvailabilityCallback;

public class AppAvailabilityJsImpl implements AppAvailability {
	@Override
	public void check(String identifier, AppAvailabilityCallback callback) {
		check0(identifier, callback);
	}

	private native void check0(String identifier, AppAvailabilityCallback callback) /*-{
		$wnd.appAvailability
				.check(
						identifier,
						function() {
							callback.@com.googlecode.gwtphonegap.client.appavailability.AppAvailabilityCallback::onAvailable()();
						},
						function() {
							callback.@com.googlecode.gwtphonegap.client.appavailability.AppAvailabilityCallback::onNotAvailable()();
						});
	}-*/;
}