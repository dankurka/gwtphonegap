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
package de.kurka.phonegap.client.capture;

import de.kurka.gwt.collection.shared.LightArray;

/**
 * Provides access to the audio, image, and video capture capabilities of the
 * device.
 * 
 * @author Daniel Kurka
 * 
 */
public interface Capture {

	/**
	 * The audio recording formats supported by the device.
	 * 
	 * @return array of {@link ConfigurationData}
	 */
	public LightArray<ConfigurationData> getSupportedAudioModes();

	/**
	 * The recording image sizes and formats supported by the device.
	 * 
	 * @return array of {@link ConfigurationData}
	 */
	public LightArray<ConfigurationData> getSupportedImageModes();

	/**
	 * The recording video resolutions and formats supported by the device.
	 * 
	 * @return array of {@link ConfigurationData}
	 */
	public LightArray<ConfigurationData> getSupportedVideoModes();

	/**
	 * Launch the device audio recording application for recording audio
	 * clip(s).
	 * 
	 * @param options
	 *            options to be used when capturing data
	 *            {@link CaptureAudioOptions}
	 * @param callback
	 *            the callback being invoked when data is ready or operation
	 *            failed
	 */
	public void captureAudio(CaptureAudioOptions options, CaptureCallback callback);

	/**
	 * Launch the device camera application for taking image(s).
	 * 
	 * @param options
	 *            options to be used when capturing data
	 *            {@link CaptureImageOptions}
	 * @param callback
	 *            the callback being invoked when data is ready or operation
	 *            failed
	 */
	public void captureImage(CaptureImageOptions options, CaptureCallback callback);

	/**
	 * Launch the device video recorder application for recording video(s).
	 * 
	 * @param options
	 *            options to be used when capturing data
	 *            {@link CaptureVideoOptions}
	 * @param callback
	 *            the callback being invoked when data is ready or operation
	 *            failed
	 */
	public void captureVideo(CaptureVideoOptions options, CaptureCallback callback);
}
