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
package de.kurka.phonegap.client.camera;

public class PictureOptions {

	public static final int DESTINATION_TYPE_DATA_URL = 0;
	public static final int DESTINATION_TYPE_FILE_URI = 1;

	public static final int PICTURE_SOURCE_TYPE_PHOTO_LIBRARY = 0;
	public static final int PICTURE_SOURCE_TYPE_CAMERA = 1;
	public static final int PICTURE_SOURCE_TYPE_SAVED_PHOTO_ALBUM = 2;

	private int quality;

	private int destinationType;
	private int sourceType;

	public PictureOptions() {
		quality = 75;
		destinationType = DESTINATION_TYPE_DATA_URL;
		sourceType = PICTURE_SOURCE_TYPE_CAMERA;
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

}
