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
 * Customize the retrieval of the compass.
 * 
 * @author Daniel Kurka
 * 
 */
public class CompassOptions {
        
        /**
         *  How often to retrieve the compass heading in milliseconds. Default: 100
         */
	private int frequency;

        /**
         * The change in degrees required to initiate a watchHeading success callback. 
         * When this value is set, frequency is ignored. 
         */
	private double filter;

	public CompassOptions() {
		this(100);
	}

	public CompassOptions(int frequency) {
		this.frequency = frequency;
		this.filter = -1;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public void setFilter(double filter) {
		this.filter = filter;
	}

	public double getFilter() {
		return filter;
	}

}
