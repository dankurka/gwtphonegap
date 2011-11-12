package com.googlecode.gwtphonegap.client.media;

public interface MediaCallback {
	public void onSuccess();

	public void onError(MediaError error);

	public void onStatusChange();
}
