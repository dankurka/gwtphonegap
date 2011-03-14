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
package de.kurka.phonegap.client.accelerometer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Contains Accelerometer data captured at a specific point in time.
 * 
 * @author Daniel Kurka
 * 
 */
public final class AccelerationJsImpl extends JavaScriptObject implements Acceleration {

	protected AccelerationJsImpl() {

	}

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Acceleration#getX()
	 */
	@Override
	public native double getX()/*-{
		return this.x;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Acceleration#getY()
	 */
	@Override
	public native double getY()/*-{
		return this.y;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Acceleration#getZ()
	 */

	@Override
	public native double getZ()/*-{
		return this.z;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.accelerometer.Acceleration#getTimeStamp()
	 */
	@Override
	public native double getTimeStamp()/*-{
		return this.timestamp;
	}-*/;

}
