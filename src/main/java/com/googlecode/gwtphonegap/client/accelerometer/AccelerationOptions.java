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
package com.googlecode.gwtphonegap.client.accelerometer;

/**
 * The Options which can be specified when reading the accelerometer
 * 
 * @author Daniel Kurka
 * 
 */
public class AccelerationOptions {
        
        /**
         *  Requested period of calls to accelerometerSuccess with acceleration data in Milliseconds. 
         */
	private double frequency;

	public AccelerationOptions() {
		this.frequency = 10000;
	}

	public AccelerationOptions(double frequency) {
		this.frequency = frequency;
	}

	public double getFrequency() {
		return frequency;
	}

	/**
	 * How often to retrieve the Acceleration in milliseconds. (Number)
	 * (Default: 10000)
	 * 
	 * @param frequency
	 */
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

}
