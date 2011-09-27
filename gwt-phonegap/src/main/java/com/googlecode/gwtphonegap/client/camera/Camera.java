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

public interface Camera {

	/**
	 * Takes a photo and returns the image as a base64 encoded String.
	 * 
	 * opens the device's default camera application so that the user to take a
	 * photo. Once the photo is taken, the camera application closes and your
	 * application is restored.
	 * 
	 * The image is base64 encoded and returned as a String in the cameraSuccess
	 * function. Since the data is a String, you can do whatever you want with
	 * it, for example:
	 * 
	 * Render the image in an <img> tag (see example below) Save the data
	 * locally (LocalStorage, Lawnchair, etc) Post the data to a remote server
	 * 
	 * @param options
	 * @param callback
	 */
	public void getPicture(PictureOptions options, PictureCallback callback);
}