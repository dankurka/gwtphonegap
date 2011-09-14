package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PauseEvent extends GwtEvent<PauseHandler> {

	public static final GwtEvent.Type<PauseHandler> TYPE = new Type<PauseHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PauseHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PauseHandler handler) {
		handler.onPause(this);

	}

	public static GwtEvent.Type<PauseHandler> getType() {
		return TYPE;
	}

}
