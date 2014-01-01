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
package com.googlecode.gwtphonegap.client.capture.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.googlecode.gwtphonegap.client.capture.Capture;
import com.googlecode.gwtphonegap.client.capture.CaptureAudioOptions;
import com.googlecode.gwtphonegap.client.capture.CaptureCallback;
import com.googlecode.gwtphonegap.client.capture.CaptureError;
import com.googlecode.gwtphonegap.client.capture.CaptureImageOptions;
import com.googlecode.gwtphonegap.client.capture.CaptureVideoOptions;
import com.googlecode.gwtphonegap.client.capture.ConfigurationData;
import com.googlecode.gwtphonegap.client.capture.MediaFile;
import com.googlecode.gwtphonegap.collection.client.JsLightArray;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

public class CaptureJsImpl implements Capture {

	@Override
	public LightArray<ConfigurationData> getSupportedAudioModes() {
		return new JsLightArray<ConfigurationData>(getSupportedAudioModes0());
	}

	private native JsArray<ConfigurationDataJsImpl> getSupportedAudioModes0()/*-{
		return $wnd.navigator.device.capture.supportedAudioModes;
	}-*/;

	@Override
	public LightArray<ConfigurationData> getSupportedImageModes() {
		return new JsLightArray<ConfigurationData>(getSupportedImageModes0());
	}

	private native JsArray<ConfigurationDataJsImpl> getSupportedImageModes0()/*-{
		return $wnd.navigator.device.capture.supportedImageModes;
	}-*/;

	@Override
	public LightArray<ConfigurationData> getSupportedVideoModes() {
		return new JsLightArray<ConfigurationData>(getSupportedVideoModes0());
	}

	private native JsArray<ConfigurationDataJsImpl> getSupportedVideoModes0()/*-{
		return $wnd.navigator.device.capture.supportedVideoModes;
	}-*/;

	private native JavaScriptObject createOptions(int limit, double duration)/*-{
		var o = {};
		o.limit = limit;
		if (duration > 0)
			o.duration = duration;
		return o;
	}-*/;

	@Override
	public void captureAudio(CaptureAudioOptions options, CaptureCallback callback) {

		JavaScriptObject gapOptions = createOptions(options.getLimit(), options.getDuration());
		captureAudio0(gapOptions, callback);

	}

	private native void captureAudio0(JavaScriptObject options, CaptureCallback callback)/*-{
		var suc = function(mediaFiles) {
			@com.googlecode.gwtphonegap.client.capture.js.CaptureJsImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/capture/CaptureCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, mediaFiles);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.capture.js.CaptureJsImpl::onFailure(Lcom/googlecode/gwtphonegap/client/capture/CaptureCallback;Lcom/googlecode/gwtphonegap/client/capture/CaptureError;)(callback, error);
		};

		$wnd.navigator.device.capture.captureAudio($entry(suc), $entry(fail),
				options);
	}-*/;

	private static void onSuccess(CaptureCallback callback, JavaScriptObject mediaFiles) {
		callback.onSuccess(new JsLightArray<MediaFile>(mediaFiles));
	}

	private static void onFailure(CaptureCallback callback, CaptureError error) {
		callback.onFailure(error);
	}

	@Override
	public void captureImage(CaptureImageOptions options, CaptureCallback callback) {
		JavaScriptObject gap_options = createOptions(options.getLimit(), -1);
		captureImage0(gap_options, callback);
	}

	private native void captureImage0(JavaScriptObject options, CaptureCallback callback) /*-{
		var suc = function(mediaFiles) {
			@com.googlecode.gwtphonegap.client.capture.js.CaptureJsImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/capture/CaptureCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, mediaFiles);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.capture.js.CaptureJsImpl::onFailure(Lcom/googlecode/gwtphonegap/client/capture/CaptureCallback;Lcom/googlecode/gwtphonegap/client/capture/CaptureError;)(callback, error);
		};

		$wnd.navigator.device.capture.captureImage($entry(suc), $entry(fail),
				options);

	}-*/;

	@Override
	public void captureVideo(CaptureVideoOptions options, CaptureCallback callback) {
		JavaScriptObject gapOptions = createOptions(options.getLimit(), options.getDuration());
		captureVideo0(gapOptions, callback);

	}

	private native void captureVideo0(JavaScriptObject options, CaptureCallback callback) /*-{
		var suc = function(mediaFiles) {
			@com.googlecode.gwtphonegap.client.capture.js.CaptureJsImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/capture/CaptureCallback;Lcom/google/gwt/core/client/JavaScriptObject;)(callback, mediaFiles);
		};

		var fail = function(error) {
			@com.googlecode.gwtphonegap.client.capture.js.CaptureJsImpl::onFailure(Lcom/googlecode/gwtphonegap/client/capture/CaptureCallback;Lcom/googlecode/gwtphonegap/client/capture/CaptureError;)(callback, error);
		};

		$wnd.navigator.device.capture.captureVideo($entry(suc), $entry(fail),
				options);

	}-*/;

}
