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
package com.googlecode.gwtphonegap.client.media.browser;

import com.googlecode.gwtphonegap.client.media.Media;
import com.googlecode.gwtphonegap.client.media.MediaCallback;
import com.googlecode.gwtphonegap.client.media.MediaModule;
import com.googlecode.gwtphonegap.client.media.MediaPositionCallback;

public class MediaModuleBrowserImpl implements MediaModule {

	@Override
	public Media create(String src, MediaCallback callback) {
		return new Media() {

			@Override
			public void getCurrentPosition(MediaPositionCallback callback) {

			}

			@Override
			public long getDuration() {

				return 0;
			}

			@Override
			public void play() {

			}

			@Override
			public void pause() {

			}

			@Override
			public void release() {

			}

			@Override
			public void seekTo(long position) {

			}

			@Override
			public void startRecord() {

			}

			@Override
			public void stopRecord() {

			}

			@Override
			public void stop() {

			}

            /**
             * Set the volume for audio playback.This is an asynchronous function that sets the volume during audio playback.
             *
             * @param volume : The volume to set for playback. The value must be within the range of 0.0 to 1.0.
             */
            @Override
            public void setVolume(double volume) {

            }

        };
	}

}
