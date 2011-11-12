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
package com.googlecode.gwtphonegap.client.accelerometer.js;

import java.util.Date;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.accelerometer.Acceleration;


public final class AccelerationJsImpl extends JavaScriptObject implements Acceleration {

	protected AccelerationJsImpl() {

	}

	@Override
	public native double getX()/*-{
		return this.x;
	}-*/;

	@Override
	public native double getY()/*-{
		return this.y;
	}-*/;

	@Override
	public native double getZ()/*-{
		return this.z;
	}-*/;

	private native double getTimeStamp0()/*-{
		return this.timestamp;
	}-*/;

	@Override
	public Date getTimeStamp() {
		return new Date(Math.round(getTimeStamp0()));
	}
}
