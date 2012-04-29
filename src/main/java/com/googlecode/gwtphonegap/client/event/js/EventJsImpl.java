/*
 * Copyright 2011 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.event.js;

import com.googlecode.gwtphonegap.client.event.EventBaseImpl;

public class EventJsImpl extends EventBaseImpl {

	private boolean backSetup;

	public EventJsImpl() {
		super();

		setupEvents();
	}

	@Override
	protected void ensureBackListener() {
		if (backSetup)
			return;
		backSetup = true;
		setupBackEvent();
	}

	private native void setupBackEvent()/*-{
		var that = this;
		//back event
		var back = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireBackEvent()();
		};
		$doc.addEventListener("backbutton", $entry(back), false);
	}-*/;

	@Override
	protected native void setupEvents()/*-{
		var that = this;

		//offline event
		var off = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireOfflineEvent()();
		};
		$doc.addEventListener("offline", $entry(off), false);

		//online event
		var on = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireOnlineEvent()();
		};
		$doc.addEventListener("online", $entry(on), false);

		//resume event
		var resume = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireResumeEvent()();
		};
		$doc.addEventListener("resume", $entry(resume), false);

		//pause event
		var pause = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::firePauseEvent()();
		};
		$doc.addEventListener("pause", $entry(pause), false);

		//search event
		var search = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireSearchEvent()();
		};
		$doc.addEventListener("searchbutton", $entry(search), false);

		//menu event
		var menu = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireMenuEvent()();
		};
		$doc.addEventListener("menubutton", $entry(menu), false);

		//battery critical event
		var bce = function(info) {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireBatteryCriticalEvent(IZ)(info.level, info.isPlugged);
		};
		$wnd.addEventListener("batterycritical", $entry(bce), false);

		//battery low event
		var ble = function(info) {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireBatteryLowEvent(IZ)(info.level, info.isPlugged);
		};
		$wnd.addEventListener("batterylow", $entry(ble), false);

		//battery status event
		var bse = function(info) {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireBatteryStatusvent(IZ)(info.level, info.isPlugged);
		};
		$wnd.addEventListener("batterystatus", $entry(bse), false);

		//start call event
		var sce = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireStartCallButtonPressedEvent()();
		};
		$doc.addEventListener("startcallbutton", $entry(sce), false);

		//end call event
		var ece = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireEndCallButtonPressedEvent()();
		};
		$doc.addEventListener("endcallbutton", $entry(ece), false);

		//volumne down button event
		var vdbe = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireVolumneButtonDownPressedEvent()();
		};
		$doc.addEventListener("volumedownbutton", $entry(vdbe), false);

		//volumne up button event
		var vube = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::fireVolumneButtonUpPressedEvent()();
		};
		$doc.addEventListener("volumeupbutton", $entry(vube), false);

	}-*/;

}
