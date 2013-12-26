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
package com.googlecode.gwtphonegap.client.media;

public interface Media {

    /**
     * Returns the current position within an audio file.
     * @param callback
     */
	public void getCurrentPosition(MediaPositionCallback callback);

    /**
     * Returns the duration of an audio file.
     * @return
     */
	public long getDuration();

    /**
     * Start or resume playing an audio file.
     */
	public void play();

    /**
     *  Pause playback of an audio file.
     */
	public void pause();

    /**
     * Releases the underlying operating system's audio resources.
     */
	public void release();

    /**
     * Moves the position within the audio file.
     * @param position
     */
	public void seekTo(long position);

    /**
     * Start recording an audio file.
     */
	public void startRecord();

    /**
     * Stop recording an audio file.
     */
	public void stopRecord();

    /**
     * Stop playing an audio file.
     */
	public void stop();

    /**
     * Set the volume for audio playback.This is an asynchronous function that sets the volume during audio playback.
     * @param volume : The volume to set for playback. The value must be within the range of 0.0 to 1.0.
     */
    public void setVolume(double volume);

}
