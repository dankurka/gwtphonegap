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
package com.googlecode.gwtphonegap.client.geolocation.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.geolocation.Coordinates;

public final class CoordinatesJsImpl extends JavaScriptObject implements Coordinates {
	protected CoordinatesJsImpl() {

	}

	public native double getLatitude()/*-{
		return this.latitude;
	}-*/;

	public native double getLongitude()/*-{
		return this.longitude;
	}-*/;

	public native double getAltitude()/*-{
		return this.altitude;
	}-*/;

	/**
	 * 
	 * @return
	 */
	//TODO this is not consitent with phonegap doc (phonegap doc seems to be wrong)
	public native double getHorizontalAccuracy()/*-{
		return this.accuracy.horizontal;
	}-*/;

	//TODO this is not consitent with phonegap doc (phonegap doc seems to be wrong)
	public native double getVerticalAccuracy()/*-{
		return this.accuracy.vertical;
	}-*/;

	//TODO this returns null on iPhone 4.1 
	public native double getAltitudeAccuracy()/*-{
		return this.altitudeAccuracy;
	}-*/;

	public native double getHeading()/*-{
		return this.heading;
	}-*/;

	public native double getSpeed()/*-{
		return this.speed;
	}-*/;

}
