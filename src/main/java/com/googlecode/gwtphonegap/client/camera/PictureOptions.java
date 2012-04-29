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

public class PictureOptions {

	public static final int DESTINATION_TYPE_DATA_URL = 0;
	public static final int DESTINATION_TYPE_FILE_URI = 1;

	public static final int PICTURE_SOURCE_TYPE_PHOTO_LIBRARY = 0;
	public static final int PICTURE_SOURCE_TYPE_CAMERA = 1;
	public static final int PICTURE_SOURCE_TYPE_SAVED_PHOTO_ALBUM = 2;

	public static final int CAMERA_ENCODING_TYPE_JPEG = 0;
	public static final int CAMERA_ENCODING_TYPE_PNG = 1;

	public static final int CAMERA_MEDIA_TYPE_PICTURE = 0;
	public static final int CAMERA_MEDIA_TYPE_VIDEO = 1;
	public static final int CAMERA_MEDIA_TYPE_ALL = 2;

	private int quality;

	private int destinationType;
	private int sourceType;
	private int encoding;

	private int targetHeightInPx;
	private int targetWidthInPx;
	private int mediaType;

	private boolean allowEdit;

	public PictureOptions() {
		quality = 75;
		destinationType = DESTINATION_TYPE_DATA_URL;
		sourceType = PICTURE_SOURCE_TYPE_CAMERA;
		encoding = CAMERA_ENCODING_TYPE_JPEG;

		// no sizing by default...
		targetHeightInPx = -1;
		targetWidthInPx = -1;

		mediaType = CAMERA_MEDIA_TYPE_PICTURE;

		allowEdit = true;
	}

	public PictureOptions(int quality) {
		this();
		this.quality = quality;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getSourceType() {
		return sourceType;
	}

	public int getDestinationType() {
		return destinationType;
	}

	public void setDestinationType(int destinationType) {
		this.destinationType = destinationType;
	}

	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}

	public int getEncoding() {
		return encoding;
	}

	public void setEncoding(int encoding) {
		this.encoding = encoding;
	}

	public void setTargetHeightInPx(int targetHeightInPx) {
		this.targetHeightInPx = targetHeightInPx;
	}

	public int getTargetHeightInPx() {
		return targetHeightInPx;
	}

	public int getTargetWidthInPx() {
		return targetWidthInPx;
	}

	public void setTargetWidthInPx(int targetWidthInPx) {
		this.targetWidthInPx = targetWidthInPx;
	}

	public void setMediaType(int mediaType) {
		this.mediaType = mediaType;
	}

	public int getMediaType() {
		return mediaType;
	}

	public void setAllowEdit(boolean allowEdit) {
		this.allowEdit = allowEdit;
	}

	public boolean isAllowEdit() {
		return allowEdit;
	}

}
