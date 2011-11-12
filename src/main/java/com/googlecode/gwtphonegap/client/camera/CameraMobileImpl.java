/*
 * Copyright 2010 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.camera;

public class CameraMobileImpl implements Camera {

	@Override
	public void getPicture(PictureOptions options, PictureCallback callback) {
		if (options == null) {
			throw new IllegalArgumentException("options can not be null");
		}

		if (callback == null) {
			throw new IllegalArgumentException("callback can not be null");
		}
		getPicture0(options, callback);
	}

	private native void getPicture0(PictureOptions options, PictureCallback callback)/*-{
		var successCallback = function(data) {
			callback.@com.googlecode.gwtphonegap.client.camera.PictureCallback::onSuccess(Ljava/lang/String;)(data);
		};

		var errorCallback = function() {
			callback.@com.googlecode.gwtphonegap.client.camera.PictureCallback::onFailure()();
		};

		var qual = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getQuality()();
		var dt = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getDestinationType()();
		var st = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getSourceType()();

		var localOptions = {
			quality : qual,
			destinationType : dt,
			sourceType : st
		};

		$wnd.navigator.camera.getPicture($entry(successCallback),
				$entry(errorCallback), localOptions);
	}-*/;

}
