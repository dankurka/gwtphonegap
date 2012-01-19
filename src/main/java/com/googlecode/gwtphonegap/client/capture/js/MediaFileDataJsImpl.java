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
import com.googlecode.gwtphonegap.client.capture.MediaFileData;

public final class MediaFileDataJsImpl extends JavaScriptObject implements MediaFileData {

	protected MediaFileDataJsImpl() {

	}

	@Override
	public native String getCodecs() /*-{
		return this.codecs;
	}-*/;

	@Override
	public long getBitRate() {
		return Math.round(getBitRate0());
	}

	private native double getBitRate0()/*-{
		return this.bitrate;
	}-*/;

	@Override
	public native int getHeight() /*-{
		return this.height;
	}-*/;

	@Override
	public native int getWidth()/*-{
		return this.width;
	}-*/;

	@Override
	public long getDuration() {
		return Math.round(getDuration0());
	}

	private native double getDuration0()/*-{
		return this.duration;
	}-*/;

}
