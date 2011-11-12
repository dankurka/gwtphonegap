package com.googlecode.gwtphonegap.client.media;

public interface MediaPositionCallback {
	public void onSuccess(long position);

	public void onFailure(MediaError error);
}
