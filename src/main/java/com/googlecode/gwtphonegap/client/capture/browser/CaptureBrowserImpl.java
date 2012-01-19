/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.capture.browser;

import com.googlecode.gwtphonegap.client.capture.Capture;
import com.googlecode.gwtphonegap.client.capture.CaptureAudioOptions;
import com.googlecode.gwtphonegap.client.capture.CaptureCallback;
import com.googlecode.gwtphonegap.client.capture.CaptureError;
import com.googlecode.gwtphonegap.client.capture.CaptureImageOptions;
import com.googlecode.gwtphonegap.client.capture.CaptureVideoOptions;
import com.googlecode.gwtphonegap.client.capture.ConfigurationData;
import com.googlecode.gwtphonegap.collection.shared.CollectionFactory;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

public class CaptureBrowserImpl implements Capture {

	@Override
	public LightArray<ConfigurationData> getSupportedAudioModes() {
		// TODO implement proper values
		LightArray<ConfigurationData> array = CollectionFactory.constructArray();
		return array;

	}

	@Override
	public LightArray<ConfigurationData> getSupportedImageModes() {
		// TODO implement proper values
		LightArray<ConfigurationData> array = CollectionFactory.constructArray();
		return array;
	}

	@Override
	public LightArray<ConfigurationData> getSupportedVideoModes() {
		// TODO implement proper values
		LightArray<ConfigurationData> array = CollectionFactory.constructArray();
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
