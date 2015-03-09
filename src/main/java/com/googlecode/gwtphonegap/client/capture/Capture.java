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
package com.googlecode.gwtphonegap.client.capture;

import com.googlecode.gwtphonegap.collection.shared.LightArray;

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
	 * Starts an asynchronous operation to capture audio recordings using the device's default 
         * audio recording application. The operation allows the device user to capture multiple recordings 
         * in a single session.The capture operation ends when either the user exits the audio recording 
         * application, or the maximum number of recordings specified by CaptureAudioOptions.limit is reached.
         * If no limit parameter value is specified, it defaults to one (1), and the capture operation 
         * terminates after the user records a single audio clip.When the capture operation finishes, 
         * the CaptureCallback executes with an array of MediaFile objects describing each captured audio 
         * clip file. If the user terminates the operation before an audio clip is captured, the
         * CaptureErrorCallback executes with a CaptureError object, featuring the 
         * CaptureError.CAPTURE_NO_MEDIA_FILES error code.
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
	 * Starts an asynchronous operation to capture images using the device's camera application.
         * The operation allows users to capture more than one image in a single session.The capture 
         * operation ends either when the user closes the camera application, or the maximum number 
         * of recordings specified by CaptureAudioOptions.limit is reached. If no limit value is specified, 
         * it defaults to one (1), and the capture operation terminates after the user captures a single image.
         * When the capture operation finishes, it invokes the CaptureCB callback with an array of MediaFile 
         * objects describing each captured image file. If the user terminates the operation before capturing 
         * an image, the CaptureErrorCB callback executes with a CaptureError object featuring a
         * CaptureError.CAPTURE_NO_MEDIA_FILES error code.
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
	 * Starts an asynchronous operation to capture video recordings using the device's video recording 
         * application. The operation allows the user to capture more than one recordings in a single session.
         * The capture operation ends when either the user exits the video recording application, or the 
         * maximum number of recordings specified by CaptureVideoOptions.limit is reached. If no limit 
         * parameter value is specified, it defaults to one (1), and the capture operation terminates 
         * after the user records a single video clip.When the capture operation finishes, it the CaptureCB 
         * callback executes with an array of MediaFile objects describing each captured video clip file. 
         * If the user terminates the operation before capturing a video clip, the CaptureErrorCB callback 
         * executes with a CaptureError object featuring a CaptureError.CAPTURE_NO_MEDIA_FILES error code.
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
