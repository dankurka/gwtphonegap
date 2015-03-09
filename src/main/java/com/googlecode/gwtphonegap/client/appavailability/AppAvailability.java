package com.googlecode.gwtphonegap.client.appavailability;

public interface AppAvailability {
	void check(String identifier, AppAvailabilityCallback callback);
}