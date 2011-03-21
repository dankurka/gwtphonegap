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
package de.kurka.phonegap.client.plugins.badge;

public class BadgePhoneGapImpl implements Badge {

	private boolean initialized;

	@Override
	public void initialize() {
		if (!testForPlugin()) {
			throw new IllegalStateException("can not find badge plugin - did you include badge.js?");
		}
		initialized = true;
	}

	private native boolean testForPlugin()/*-{
		if (!$wnd.plugins)
			return false;
		if (!$wnd.plugins.badge)
			return false;
		return true;
	}-*/;

	@Override
	public void setBadge(int number) {
		if (!initialized) {
			throw new IllegalStateException("you have to initialize Badge Plugin before using it");
		}
		setBadgeNative(number);
	}

	private native void setBadgeNative(int number)/*-{
		$wnd.plugins.badge.set(number);
	}-*/;

	@Override
	public void clear() {
		if (!initialized) {
			throw new IllegalStateException("you have to initialize Badge Plugin before using it");
		}
		setBadgeNative(0);
	}

}
