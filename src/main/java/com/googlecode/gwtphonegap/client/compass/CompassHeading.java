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

public interface CompassHeading {
    
        /**
         * The heading in degrees from 0-359.99 at a single moment in time. 
         * @return 
         */
	public double getMagneticHeading();

        /**
         * The heading relative to the geographic North Pole in degrees 0-359.99 
         * at a single moment in time. A negative value indicates that the true 
         * heading can't be determined. 
         * @return 
         */
	public double getTrueHeading();

        /**
         * The deviation in degrees between the reported heading and the true heading. 
         * @return 
         */
	public double getHeadingAccuracy();

        /**
         * The time at which this heading was determined. 
         * @return 
         */
	public long getTimeStamp();
}
