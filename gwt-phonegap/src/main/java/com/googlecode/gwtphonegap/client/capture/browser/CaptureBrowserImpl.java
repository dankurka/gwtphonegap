package com.googlecode.gwtphonegap.client.capture.browser;

import com.googlecode.gwtphonegap.client.capture.Capture;
import com.googlecode.gwtphonegap.client.capture.CaptureAudioOptions;
import com.googlecode.gwtphonegap.client.capture.CaptureCallback;
import com.googlecode.gwtphonegap.client.capture.CaptureError;
import com.googlecode.gwtphonegap.client.capture.CaptureImageOptions;
import com.googlecode.gwtphonegap.client.capture.CaptureVideoOptions;
import com.googlecode.gwtphonegap.client.capture.ConfigurationData;

import de.kurka.gwt.collection.shared.GwtCollectionFactory;
import de.kurka.gwt.collection.shared.LightArray;

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
