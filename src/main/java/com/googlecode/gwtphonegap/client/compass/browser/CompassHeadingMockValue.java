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
package com.googlecode.gwtphonegap.client.compass.browser;

import com.googlecode.gwtphonegap.client.compass.CompassHeading;

public class CompassHeadingMockValue implements CompassHeading {

	private final double magneticHeading;
	private final double trueHeading;
	private final double headingAccuracy;
	private final long timeStamp;

	public CompassHeadingMockValue(double magneticHeading, double trueHeading, double headingAccuracy) {
		this.magneticHeading = magneticHeading;
		this.trueHeading = trueHeading;
		this.headingAccuracy = headingAccuracy;
		this.timeStamp = System.currentTimeMillis();
	}

	@Override
	public double getMagneticHeading() {
		return magneticHeading;
	}

	@Override
	public double getTrueHeading() {
		return trueHeading;
	}

	@Override
	public double getHeadingAccuracy() {
		return headingAccuracy;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

}
