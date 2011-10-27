package com.googlecode.gwtphonegap.client.event;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

public abstract class EventBaseImpl implements Event, EventMock {

	protected final PhoneGapEventHandlerImpl pgImpl;
	private final EventBus eventBus;

	public EventBaseImpl() {
		eventBus = new SimpleEventBus();
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

}