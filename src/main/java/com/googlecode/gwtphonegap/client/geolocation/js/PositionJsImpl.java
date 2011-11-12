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
import com.googlecode.gwtphonegap.client.geolocation.Position;

/**
 * Contains PositionJsImpl coordinates that are created by the geolocation API.
 * 
 * 
 * The PositionJsImpl object is created and populated by PhoneGap, and returned
 * to the user through a callback function.
 * <ul>
 * <li>Android</li>
 * <li>BlackBerry</li>
 * <li>BlackBerry Widgets (OS 5.0 and higher)</li>
 * <li>iPhone</li>
 * </ul>
 * 
 * @author Daniel Kurka
 * 
 */
public final class PositionJsImpl extends JavaScriptObject implements Position {

	protected PositionJsImpl() {

	}

	public native CoordinatesJsImpl getCoordinates()/*-{
		return this.coords;
	}-*/;

	private native double getTimeStamp0()/*-{
		return this.timestamp;
	}-*/;

	@Override
	public long getTimeStamp() {
		return Math.round(getTimeStamp0());
	}

}
