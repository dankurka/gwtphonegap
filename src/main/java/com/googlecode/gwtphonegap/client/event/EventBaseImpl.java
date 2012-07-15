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
package com.googlecode.gwtphonegap.client.event;

import com.google.web.bindery.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.HandlerRegistration;

public abstract class EventBaseImpl implements Event, EventMock {

	protected final PhoneGapEventHandlerImpl pgImpl;
	private EventBus eventBus;

	public EventBaseImpl() {
		pgImpl = new PhoneGapEventHandlerImpl();
	}

	public HasBackButtonPressedHandlers getBackButton() {
		return pgImpl;
	}

	public HasMenuButtonPressedHandlers getMenuButton() {
		return pgImpl;
	}

	public HasSearchButtonHandlers getSearchButton() {
		return pgImpl;
	}

	public HasPauseHandlers getPauseHandler() {
		return pgImpl;
	}

	public HasResumeHandlers getResumeHandler() {
		return pgImpl;
	}

	public HasOnlineHandler getOnlineHandler() {
		return pgImpl;
	}

	public HasOfflineHandler getOffLineHandler() {
		return pgImpl;
	}

	@Override
	public HasBatteryCriticalHandler getBatteryCriticalHandler() {
		return pgImpl;
	}

	@Override
	public HasBatteryLowHandler getBatteryLowHandler() {
		return pgImpl;
	}

	@Override
	public HasBatteryStatusHandler getBatteryStatusHandler() {
		return pgImpl;
	}

	@Override
	public HasStartCallButtonHandler getStartCallButtonHandler() {
		return pgImpl;
	}

	@Override
	public HasEndCallButtonHandler getEndCallButtonHandler() {
		return pgImpl;
	}

	@Override
	public HasVolumneDownButtonPressedHandler getVolumneDownButtonPressedHandler() {
		return pgImpl;
	}

	@Override
	public HasVolumneUpButtonPressedHandler getVolumneUpButtonPressedHandler() {
		return pgImpl;
	}

	private class PhoneGapEventHandlerImpl implements HasOfflineHandler, HasOnlineHandler, HasResumeHandlers, HasPauseHandlers, HasBackButtonPressedHandlers, HasSearchButtonHandlers,
			HasMenuButtonPressedHandlers, HasBatteryCriticalHandler, HasBatteryLowHandler, HasBatteryStatusHandler, HasStartCallButtonHandler, HasEndCallButtonHandler,
			HasVolumneDownButtonPressedHandler, HasVolumneUpButtonPressedHandler {

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

		@Override
		public HandlerRegistration addBatteryCriticalHandler(BatteryCriticalHandler handler) {
			return eventBus.addHandler(BatteryCriticalEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addBatteryLowHandler(BatteryLowHandler handler) {
			return eventBus.addHandler(BatteryLowEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addBatteryStatusHandler(BatteryStatusHandler handler) {
			return eventBus.addHandler(BatteryStatusEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addStartCallButtonHandler(StartCallButtonPressedHandler handler) {
			return eventBus.addHandler(StartCallButtonPressedEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addEndCallButtonHandler(EndCallButtonPressedHandler handler) {
			return eventBus.addHandler(EndCallButtonPressedEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addVolumneDownButtonPressedHandler(VolumeDownButtonPressedHandler handler) {
			return eventBus.addHandler(VolumeDownButtonPressedEvent.getType(), handler);
		}

		@Override
		public HandlerRegistration addVolumneUpButtonPressedHandler(VolumeUpButtonPressedHandler handler) {
			return eventBus.addHandler(VolumeUpButtonPressedEvent.getType(), handler);
		}

	}

	protected abstract void ensureBackListener();

	protected abstract void setupEvents();

	@Override
	public void fireOfflineEvent() {
		eventBus.fireEvent(new OffLineEvent());

	}

	@Override
	public void fireOnlineEvent() {
		eventBus.fireEvent(new OnlineEvent());

	}

	@Override
	public void fireResumeEvent() {
		eventBus.fireEvent(new ResumeEvent());

	}

	@Override
	public void firePauseEvent() {
		eventBus.fireEvent(new PauseEvent());

	}

	@Override
	public void fireBackEvent() {
		eventBus.fireEvent(new BackButtonPressedEvent());

	}

	@Override
	public void fireSearchEvent() {
		eventBus.fireEvent(new SearchButtonPressedEvent());

	}

	@Override
	public void fireMenuEvent() {
		eventBus.fireEvent(new MenuButtonPressedEvent());

	}

	@Override
	public void fireBatteryCriticalEvent(int level, boolean plugged) {
		eventBus.fireEvent(new BatteryCriticalEvent(level, plugged));
	}

	@Override
	public void fireBatteryLowEvent(int level, boolean plugged) {
		eventBus.fireEvent(new BatteryLowEvent(level, plugged));
	}

	@Override
	public void fireBatteryStatusvent(int level, boolean plugged) {
		eventBus.fireEvent(new BatteryStatusEvent(level, plugged));
	}

	@Override
	public void fireStartCallButtonPressedEvent() {
		eventBus.fireEvent(new StartCallButtonPressedEvent());
	}

	@Override
	public void fireEndCallButtonPressedEvent() {
		eventBus.fireEvent(new EndCallButtonPressedEvent());
	}

	@Override
	public void fireVolumneButtonDownPressedEvent() {
		eventBus.fireEvent(new VolumeDownButtonPressedEvent());
	}

	@Override
	public void fireVolumneButtonUpPressedEvent() {
		eventBus.fireEvent(new VolumeUpButtonPressedEvent());
	}

  @Override
  public void setEventBus(EventBus eventBus) {
    this.eventBus = eventBus;
  }
}