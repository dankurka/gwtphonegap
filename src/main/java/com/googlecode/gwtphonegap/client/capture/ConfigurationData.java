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

/**
 * Encapsulates a set of media capture parameters that a device supports.
 * Describes media capture modes supported by the device.
 * The configuration data includes the MIME type, 
 * and capture dimensions for video or image capture.
 * @author Daniel Kurka
 */
public interface ConfigurationData {
    
        /**
         * The ASCII-encoded lowercase string representing the media type.
         * @return 
         */
	public String getType();

        /**
         * The height of the image or video in pixels. The value is zero for sound clips.
         * @return 
         */
	public int getHeight();

        /**
         * The width of the image or video in pixels. The value is zero for sound clips. 
         * @return 
         */
	public int getWidth();
}
