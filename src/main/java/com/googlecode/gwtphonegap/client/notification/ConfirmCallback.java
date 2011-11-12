package com.googlecode.gwtphonegap.client.notification;

public interface ConfirmCallback {
	//TODO phonegap doc is incorrect about buttons take a look at the implementations for android, ios and blackberry
	public void onConfirm(int button);
}
