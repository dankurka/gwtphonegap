package de.kurka.phonegap.client.capture.browser;

import de.kurka.gwt.collection.shared.GwtCollectionFactory;
import de.kurka.gwt.collection.shared.LightArray;
import de.kurka.phonegap.client.capture.Capture;
import de.kurka.phonegap.client.capture.CaptureAudioOptions;
import de.kurka.phonegap.client.capture.CaptureCallback;
import de.kurka.phonegap.client.capture.CaptureError;
import de.kurka.phonegap.client.capture.CaptureImageOptions;
import de.kurka.phonegap.client.capture.CaptureVideoOptions;
import de.kurka.phonegap.client.capture.ConfigurationData;

public class CaptureBrowserImpl implements Capture {

	@Override
	public LightArray<ConfigurationData> getSupportedAudioModes() {
		//TODO implement proper values
		LightArray<ConfigurationData> array = GwtCollectionFactory.constructArray();
		return array;

	}

	@Override
	public LightArray<ConfigurationData> getSupportedImageModes() {
		//TODO implement proper values
		LightArray<ConfigurationData> array = GwtCollectionFactory.constructArray();
		return array;
	}

	@Override
	public LightArray<ConfigurationData> getSupportedVideoModes() {
		//TODO implement proper values
		LightArray<ConfigurationData> array = GwtCollectionFactory.constructArray();
		return array;
	}

	@Override
	public void captureAudio(CaptureAudioOptions options, CaptureCallback callback) {
		callback.onFailure(new CaptureError() {

			@Override
			public int getCode() {
				return CaptureError.CAPTURE_NOT_SUPPORTED;
			}
		});

	}

	@Override
	public void captureImage(CaptureImageOptions options, CaptureCallback callback) {
		callback.onFailure(new CaptureError() {

			@Override
			public int getCode() {
				return CaptureError.CAPTURE_NOT_SUPPORTED;
			}
		});

	}

	@Override
	public void captureVideo(CaptureVideoOptions options, CaptureCallback callback) {
		callback.onFailure(new CaptureError() {

			@Override
			public int getCode() {
				return CaptureError.CAPTURE_NOT_SUPPORTED;
			}
		});

	}

}
