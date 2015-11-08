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
package com.googlecode.gwtphonegap.client.compass;

/**
 * Obtains the direction that the device is pointing.
 * 
 * @author Daniel Kurka
 * 
 */
public interface Compass {
	/**
	 * Get the current compass heading.
	 * 
	 * The compass is a sensor that detects the direction or heading that the
	 * device is pointed. It measures the heading in degrees from 0 to 359.99.
	 * 
	 * The compass heading is returned using the {@link CompassCallback }
	 * 
	 * <h2>Supported Platforms</h2>
	 * <ul>
	 * 
	 * <li>Android</li>
	 * <li>iPhone</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param options
	 *            the options when capturing data (not used)
	 * @param callback
	 *            the callback to invoke when data is ready or operation has
	 *            failed
	 */
	public void getCurrentHeading(CompassOptions options, CompassCallback callback);

	/**
	 * At a regular interval, get the compass heading in degrees.
	 * 
	 * The compass is a sensor that detects the direction or heading that the
	 * device is pointed. It measures the heading in degrees from 0 to 359.99.
	 * 
	 * The compass.watchHeading gets the device's current heading at a regular
	 * interval. Each time the heading is retrieved, the headingSuccess callback
	 * function is executed. Specify the interval in milliseconds via the
	 * frequency parameter in the compassOptions object.
	 * 
	 * The returned watch ID references references the compass watch interval.
	 * The watch ID can be used with compass.clearWatch to stop watching the
	 * compass.
	 * 
	 * <h2>Supported Platforms</h2>
	 * <ul>
	 * 
	 * <li>Android</li>
	 * <li>iPhone</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param options
	 *            the options when capturing data
	 * @param callback
	 *            the callback to invoke when data is ready or operation has
	 *            failed
	 * @return reference to clear the watcher
	 */
	public CompassWatcher watchHeading(CompassOptions options, CompassCallback callback);

	/**
	 * Stop watching the compass referenced by the watch ID parameter.
	 * 
	 * @param watcher
	 *            the watcher from
	 *            {@link #watchHeading(CompassOptions, CompassCallback)}
	 */
	public void clearWatcher(CompassWatcher watcher);
}
