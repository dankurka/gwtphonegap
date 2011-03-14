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
package de.kurka.phonegap.client.device;

/**
 * The Device class represents the Device from the phonegap API:
 * 
 * http://docs.phonegap.com/phonegap_device_device.md.html
 * 
 * @author Daniel Kurka
 * 
 */
public class DeviceMobileImpl implements Device {

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.device.Device#isAvailable()
	 */
	@Override
	public native boolean isAvailable() /*-{
		if(!(typeof($wnd.device) == "undefined"))
		{
		return true;
		}
		return false;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.device.Device#getName()
	 */
	@Override
	public native String getName()/*-{
		return $wnd.device.name;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.device.Device#getPhoneGapVersion()
	 */
	@Override
	public native String getPhoneGapVersion()/*-{
		return $wnd.device.phonegap;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.device.Device#getPlatform()
	 */
	@Override
	public native String getPlatform()/*-{
		return $wnd.device.platform;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.device.Device#getUuid()
	 */
	@Override
	public native String getUuid()/*-{
		return $wnd.device.uuid;
	}-*/;

	/* (non-Javadoc)
	 * @see de.kurka.phonegap.client.device.Device#getVersion()
	 */
	@Override
	public native String getVersion()/*-{
		return $wnd.device.version;
	}-*/;

}
