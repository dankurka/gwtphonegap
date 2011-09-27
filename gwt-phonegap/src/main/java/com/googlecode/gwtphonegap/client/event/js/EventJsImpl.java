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

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.BackButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.Event;
import com.googlecode.gwtphonegap.client.event.HasBackButtonPressedHandlers;
import com.googlecode.gwtphonegap.client.event.HasMenuButtonPressedHandlers;
import com.googlecode.gwtphonegap.client.event.HasOfflineHandler;
import com.googlecode.gwtphonegap.client.event.HasOnlineHandler;
import com.googlecode.gwtphonegap.client.event.HasPauseHandlers;
import com.googlecode.gwtphonegap.client.event.HasResumeHandlers;
import com.googlecode.gwtphonegap.client.event.HasSearchButtonHandlers;
import com.googlecode.gwtphonegap.client.event.MenuButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.MenuButtonPressedHandler;
import com.googlecode.gwtphonegap.client.event.OffLineEvent;
import com.googlecode.gwtphonegap.client.event.OffLineHandler;
import com.googlecode.gwtphonegap.client.event.OnlineEvent;
import com.googlecode.gwtphonegap.client.event.OnlineHandler;
import com.googlecode.gwtphonegap.client.event.PauseEvent;
import com.googlecode.gwtphonegap.client.event.PauseHandler;
import com.googlecode.gwtphonegap.client.event.ResumeEvent;
import com.googlecode.gwtphonegap.client.event.ResumeHandler;
import com.googlecode.gwtphonegap.client.event.SearchButtonPressedEvent;
import com.googlecode.gwtphonegap.client.event.SearchButtonPressedHandler;


public class EventJsImpl implements Event {

	private final EventBus eventBus;

	private PhoneGapEventHandlerImpl pgImpl;

	private boolean backSetup;

	public EventJsImpl() {
		eventBus = new SimpleEventBus();

		pgImpl = new PhoneGapEventHandlerImpl();
		setupEvents();
	}

	private void ensureBackListener() {
		if (backSetup)
			return;
		backSetup = true;
		setupBackEvent();
	}

	private native void setupBackEvent()/*-{
		var that = this;
		//back event
		var back = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onBack()();
		};
		$doc.addEventListener("backbutton", $entry(back), false);
	}-*/;

	private native void setupEvents()/*-{
		var that = this;

		//offline event
		var off = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onOffline()();
		};
		$doc.addEventListener("offline", $entry(off), false);

		//online event
		var on = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onOnline()();
		};
		$doc.addEventListener("online", $entry(on), false);

		//resume event
		var resume = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onResume()();
		};
		$doc.addEventListener("resume", $entry(resume), false);

		//pause event
		var pause = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onPause()();
		};
		$doc.addEventListener("pause", $entry(pause), false);

		//search event
		var search = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onSearch()();
		};
		$doc.addEventListener("searchbutton", $entry(search), false);

		//menu event
		var menu = function() {
			that.@com.googlecode.gwtphonegap.client.event.js.EventJsImpl::onMenu()();
		};
		$doc.addEventListener("menubutton", $entry(menu), false);
	}-*/;

	private void onOffline() {
		eventBus.fireEvent(new OffLineEvent());
	}

	private void onOnline() {
		eventBus.fireEvent(new OnlineEvent());
	}

	private void onResume() {
		eventBus.fireEvent(new ResumeEvent());
	}

	private void onPause() {
		eventBus.fireEvent(new PauseEvent());
	}

	private void onBack() {
		eventBus.fireEvent(new BackButtonPressedEvent());
	}

	private void onSearch() {
		eventBus.fireEvent(new SearchButtonPressedEvent());
	}

	private void onMenu() {
		eventBus.fireEvent(new MenuButtonPressedEvent());
	}

	@Override
	public HasBackButtonPressedHandlers getBackButton() {
		return pgImpl;
	}

	@Override
	public HasMenuButtonPressedHandlers getMenuButton() {
		return pgImpl;
	}

	@Override
	public HasSearchButtonHandlers getSearchButton() {
		return pgImpl;
	}

	@Override
	public HasPauseHandlers getPauseHandler() {
		return pgImpl;
	}

	@Override
	public HasResumeHandlers getResumeHandler() {
		return pgImpl;
	}

	@Override
	public HasOnlineHandler getOnlineHandler() {
		return pgImpl;
	}

	@Override
	public HasOfflineHandler getOffLineHandler() {
		return pgImpl;
	}

	private class PhoneGapEventHandlerImpl implements HasOfflineHandler, HasOnlineHandler, HasResumeHandlers, HasPauseHandlers, HasBackButtonPressedHandlers, HasSearchButtonHandlers,
			HasMenuButtonPressedHandlers {

		@Override
		public void fireEvent(GwtEvent<?> event) {
			eventBus.fireEvent(event);

		}

		@Override
		public HandlerRegistration addOfflineHandler(OffLineHandler handler) {
			return eventBus.addHandler(OffLineEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addOnlineHandler(OnlineHandler handler) {
			return eventBus.addHandler(OnlineEvent.getType(), handler);

		}

		@Override
		public HandlerRegistration addResumeHandler(ResumeHandler handler) {
			return eventBus.addHandler(ResumeEvent.getType(), handler);

		}

		@Override
		public HandlerRegistration addPauseHandler(PauseHandler handler) {
			return eventBus.addHandler(PauseEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addBackButtonPressedHandler(BackButtonPressedHandler handler) {
			ensureBackListener();
			return eventBus.addHandler(BackButtonPressedEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addSearchButtonHandler(SearchButtonPressedHandler handler) {
			return eventBus.addHandler(SearchButtonPressedEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addMenuButtonPressedHandler(MenuButtonPressedHandler handler) {
			return eventBus.addHandler(MenuButtonPressedEvent.getType(), handler);
		}

	}

}
