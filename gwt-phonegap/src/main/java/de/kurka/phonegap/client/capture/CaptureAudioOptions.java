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
package de.kurka.phonegap.client.capture;

/**
 * Encapsulates audio capture configuration options.
 * 
 * @author Daniel Kurka
 * 
 */
public class CaptureAudioOptions {
	private int limit;

	private long duration;

	private ConfigurationData mode;

	public CaptureAudioOptions(ConfigurationData mode) {
		if (mode == null) {
			throw new IllegalArgumentException("mode can not be null");
		}
		this.mode = mode;
		this.limit = 1;
		this.duration = -1;
	}

	/**
	 * The maximum number of audio clips the device user can record in a single
	 * capture operation. The value must be greater than or equal to 1 (defaults
	 * to 1).
	 * 
	 * @param limit
	 *            limit of clips to capture
	 * @throws IllegalArgumentException
	 *             if limit < 1
	 */
	public void setLimit(int limit) {
		if (limit < 1) {
			throw new IllegalArgumentException("limit must be greater than zero");
		}
		this.limit = limit;
	}

	/**
	 * 
	 * @return the limit of clips to capture
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * The maximum duration of an audio sound clip, in seconds. Defaulting to -1
	 * => no limit
	 * 
	 * @param duration
	 *            in seconds
	 */
	public void setDuration(long duration) {
		this.duration = duration;
	}

	/**
	 * The maximum duration of an audio sound clip, in seconds.
	 * 
	 * @return duration in seconds
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * Get the selected mode
	 * 
	 * @return
	 */
	public ConfigurationData getMode() {
		return mode;
	}
}
