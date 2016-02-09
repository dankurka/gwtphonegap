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
package com.googlecode.gwtphonegap.client.device;

/**
 * This plugin defines a global device object, which describes the device's hardware and software. 
 * Although the object is in the global scope, it is not available until after the deviceready event.
 *
 * @author Daniel Kurka
 *
 */
public class DeviceMobileImpl implements Device {


	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.device.Device#getPhoneGapVersion()
	 */
	@Override
	public native String getPhoneGapVersion()/*-{
		return $wnd.device.cordova;
  }-*/;

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.device.Device#getPlatform()
	 */
	@Override
	public native String getPlatform()/*-{
		return $wnd.device.platform;
  }-*/;

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.device.Device#getUuid()
	 */
	@Override
	public native String getUuid()/*-{
		return $wnd.device.uuid;
  }-*/;

	/* (non-Javadoc)
	 * @see com.googlecode.gwtphonegap.client.device.Device#getVersion()
	 */
	@Override
	public native String getVersion()/*-{
		return $wnd.device.version;
  }-*/;

        @Override
        public native String getModel() /*-{
            return $wnd.device.model;
        }-*/;

        @Override
        public native boolean isAvailable() /*-{
          return $wnd.device != null;
        }-*/;

        @Override
        public native String getManufacturer() /*-{
          return $wnd.device.manufacturer;
        }-*/;

        @Override
        public native boolean isVirtual()  /*-{
          return $wnd.device.isVirtual;
        }-*/;

        @Override
        public native String getSerial()  /*-{
          return $wnd.device.serial;
        }-*/;
}
