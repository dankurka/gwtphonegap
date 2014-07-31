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
package com.googlecode.gwtphonegap.client.geolocation;

public interface PositionError {

        /**
         * Returned when users do not allow the app to retrieve position information. 
         * This is dependent on the platform.
         */    
	public static final int PERMISSION_DENIED = 1;
        
        /**
         * Returned when the device is unable to retrieve a position. 
         * In general, this means the device is not connected 
         * to a network or can't get a satellite fix.
         */
	public static final int POSITION_UNAVAILABLE = 2;
        
        /**
         * Returned when the device is unable to retrieve a position within the time specified by the timeout included 
         * in geolocationOptions. When used with watchPosition, this error could be repeatedly 
         * passed to the geolocationError callback every timeout milliseconds.
         */
	public static final int TIMEOUT = 3;

	/**
	 * One of the predefined error codes listed in this class.
	 * 
	 * @return
	 */
	public int getCode();

	/**
	 * Error message describing the details of the error encountered.
	 * 
	 * @return
	 */
	public String getMessage();

}