/*
 * -/ * Copyright 2011 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.geolocation;

/**
 * The Coordinates object is attached to the Position object that is available to callback
 * functions in requests for the current position.
 */
public interface Coordinates {

    /**
     *  Latitude in decimal degrees. (Number)
     * @return double
     */
	public double getLatitude();

    /**
     * Longitude in decimal degrees. (Number)
     * @return double
     */
	public double getLongitude();

    /**
     * Height of the position in meters above the ellipsoid. (Number)
     * @return double
     */
	public double getAltitude();

    /**
     *  Accuracy level of the latitude and longitude coordinates in meters. (Number)
     * @return double
     */
	public double getAccuracy();

    /**
     *  Accuracy level of the altitude coordinate in meters. (Number)
     * @return double
     */
	public double getAltitudeAccuracy();

    /**
     * Direction of travel, specified in degrees counting clockwise relative to the true north. (Number)
     * @return double
     */
	public double getHeading();

    /**
     * Current ground speed of the device, specified in meters per second. (Number)
     * @return double
     */
	public double getSpeed();
}
