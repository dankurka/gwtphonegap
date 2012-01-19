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

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.capture.MediaFile;
import com.googlecode.gwtphonegap.client.capture.MediaFormatDataCallback;

public final class MediaFileJsImpl extends JavaScriptObject implements MediaFile {

	protected MediaFileJsImpl() {

	}

	@Override
	public native String getName() /*-{
		return this.name;
	}-*/;

	@Override
	public native String getFullPath() /*-{
		return this.fullPath;
	}-*/;

	@Override
	public native String getType()/*-{
		return this.type;
	}-*/;

	@Override
	public native Date getLastModifiedDate() /*-{
		return @com.googlecode.gwtphonegap.client.capture.js.MediaFileJsImpl::createDate(D)(this.lastModifiedDate.getTime());
	}-*/;

	public static Date createDate(double time) {
		return new Date(Math.round(time));
	}

	@Override
	public long getSize() {
		return Math.round(getSize0());
	}

	private native double getSize0()/*-{
		return this.size;
	}-*/;

	@Override
	public native void getFormatData(MediaFormatDataCallback callback) /*-{

		var suc = function(data) {
			callback.@com.googlecode.gwtphonegap.client.capture.MediaFormatDataCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/capture/MediaFileData;)(data);
		};

		var fail = function() {
			callback.@com.googlecode.gwtphonegap.client.capture.MediaFormatDataCallback::onFailure()();
		};

		this.getFormatData($entry(suc), $entry(fail));

	}-*/;

}
