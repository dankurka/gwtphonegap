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
 * Encapsulates format information about a media file.
 * @author Daniel Kurka
 */
public interface MediaFileData {
    
        /**
         * The actual format of the audio and video content. 
         * @return 
         */
	public String getCodecs();

        /**
         * The average bitrate of the content. The value is zero for images. 
         * @return 
         */
	public long getBitRate();

        /**
         * The height of the image or video in pixels. The value is zero for audio clips. 
         * @return 
         */
	public int getHeight();

        /**
         * The width of the image or video in pixels. The value is zero for audio clips.
         * @return 
         */
	public int getWidth();

        /**
         * The length of the video or sound clip in seconds. The value is zero for images. 
         * @return 
         */
	public long getDuration();
}
