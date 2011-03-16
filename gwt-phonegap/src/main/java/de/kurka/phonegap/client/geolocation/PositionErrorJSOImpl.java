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
 * A PositionError object is returned to the geolocationError callback when an error occurs.
 * @author Daniel Kurka
 *
 */
public final class PositionErrorJSOImpl extends JavaScriptObject implements PositionError {

	protected PositionErrorJSOImpl() {

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.geolocation.PostionError#getCode()
	 */
	@Override
	public native int getCode()/*-{
		return this.code;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.geolocation.PostionError#getMessage()
	 */
	@Override
	public native String getMessage()/*-{
		return this.message;
	}-*/;

}
