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
package com.googlecode.gwtphonegap.showcase.client.device;

import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwtphonegap.client.PhoneGap;


public class DevicePresenter {

	private final Display display;
	private final PhoneGap phoneGap;

	public DevicePresenter(Display display, PhoneGap phoneGap) {
		this.display = display;
		this.phoneGap = phoneGap;

		getDeviceInfos();

	}

	private void getDeviceInfos() {

		display.setVersion(phoneGap.getDevice().getVersion());
		display.setName(phoneGap.getDevice().getName());
		display.setPhoneGapVersion(phoneGap.getDevice().getPhoneGapVersion());
		display.setPlatform(phoneGap.getDevice().getPlatform());
		display.setUUID(phoneGap.getDevice().getUuid());

	}

	public interface Display {
		public Widget asWidget();

		public void setUUID(String uuid);

		public void setPlatform(String platform);

		public void setPhoneGapVersion(String phoneGapVersion);

		public void setName(String name);

		public void setVersion(String version);
	}

	public Display getDisplay() {
		return display;
	}

}
