/*
 * Copyright 2010 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
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

		var errorCallback = function(message) {
			callback.@com.googlecode.gwtphonegap.client.camera.PictureCallback::onFailure(Ljava/lang/String;)(message);
		};

		var qual = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getQuality()();
		var dt = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getDestinationType()();
		var st = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getSourceType()();

		//private int encoding;

		//private int mediaType;

		var encoding = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getEncoding()();
		var g_allowEdit = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::isAllowEdit()();
		var mediaType = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getMediaType()();

		var g_photo_al = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::isSaveToPhotoAlbum()();
		var g_correct_o = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::isCorrectorientation()();

		var localOptions = {
			quality : qual,
			destinationType : dt,
			sourceType : st,
			allowEdit : g_allowEdit,
			encodingType : encoding,
			saveToPhotoAlbum : g_photo_al,
			correctOrientation : g_correct_o
		};

		var jpop = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getPopOverOptions()();

		if (jpop != null) {
			var popOver = {};

			popOver["x"] = jpop.@com.googlecode.gwtphonegap.client.camera.PopOverOptions::getX()();
			popOver["y"] = jpop.@com.googlecode.gwtphonegap.client.camera.PopOverOptions::getY()();
			popOver["width"] = jpop.@com.googlecode.gwtphonegap.client.camera.PopOverOptions::getWidth()();
			popOver["height"] = jpop.@com.googlecode.gwtphonegap.client.camera.PopOverOptions::getHeight()();
			popOver["arrowDir"] = jpop.@com.googlecode.gwtphonegap.client.camera.PopOverOptions::getArrowDir()();

			localOptions["popoverOptions"] = popOver;

		}

		var th = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getTargetHeightInPx()();
		if (th != -1) {
			localOptions["targetHeight"] = th;
		}

		var tw = options.@com.googlecode.gwtphonegap.client.camera.PictureOptions::getTargetWidthInPx()();
		if (tw != -1) {
			localOptions["targetWidth"] = tw;
		}

		$wnd.navigator.camera.getPicture($entry(successCallback),
				$entry(errorCallback), localOptions);
  }-*/;

  @Override
  public native void cleanUp(CameraCallback callback) /*-{

		var win = function() {
			callback.@com.googlecode.gwtphonegap.client.camera.CameraCallback::onSuccess()();
		};

		var fail = function(message) {
			callback.@com.googlecode.gwtphonegap.client.camera.CameraCallback::onError(Ljava/lang/String;)(message);
		};

		$wnd.navigator.camera.cleanup($entry(win), $entry(fail));

  }-*/;

}
