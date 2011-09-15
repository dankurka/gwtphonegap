package de.kurka.phonegap.client.capture;

import de.kurka.gwt.collection.shared.LightArray;

public interface CaptureCallback {
	public void onSuccess(LightArray<MediaFile> mediaFiles);

	public void onFailure(CaptureError error);
}
