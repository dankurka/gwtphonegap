package de.kurka.phonegap.client.capture;

import de.kurka.gwt.collection.shared.LightArray;

public interface Capture {

	public LightArray<ConfigurationData> getSupportedAudioModes();

	public LightArray<ConfigurationData> getSupportedImageModes();

	public LightArray<ConfigurationData> getSupportedVideoModes();

	public void captureAudio(CaptureAudioOptions options, CaptureCallback callback);

	public void captureImage(CaptureImageOptions options, CaptureCallback callback);

	public void captureVideo(CaptureVideoOptions options, CaptureCallback callback);
}
