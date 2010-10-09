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
package de.kurka.phonegap.client.geolocation;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Contains Position coordinates that are created by the geolocation API.
 * 
 * 
 * The Position object is created and populated by PhoneGap, and returned to the user through a callback function.
 * <ul>
 * 	<li>Android</li>
 * 	<li>BlackBerry</li>
 * 	<li>BlackBerry Widgets (OS 5.0 and higher)</li>
 * 	<li>iPhone</li>
 * </ul>
 * 
 * @author Daniel Kurka
 *
 */
public final class Position extends JavaScriptObject {

	protected Position() {

	}

	public native Coordinates getCoordinates()/*-{
		return this.coords;
	}-*/;

	public native double getTimeStamp()/*-{
		return this.timestamp;
	}-*/;

}
