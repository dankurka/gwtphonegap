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
package com.googlecode.gwtphonegap.client.compass.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.compass.CompassHeading;

public final class CompassHeadingJsImpl extends JavaScriptObject implements CompassHeading {

	protected CompassHeadingJsImpl() {

	}

	@Override
	public native double getMagneticHeading()/*-{
		return this.magneticHeading;
	}-*/;

	@Override
	public native double getTrueHeading()/*-{
		return this.trueHeading;
	}-*/;

	@Override
	public native double getHeadingAccuracy() /*-{
		return this.headingAccuracy;
	}-*/;

	@Override
	public long getTimeStamp() {
		return Math.round(getTimeStamp0());
	}

	private native double getTimeStamp0()/*-{
		return this.timestamp;
	}-*/;

}
