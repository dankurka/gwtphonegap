package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class BackButtonPressedEvent extends GwtEvent<BackButtonPressedHandler> {

	public static final GwtEvent.Type<BackButtonPressedHandler> TYPE = new GwtEvent.Type<BackButtonPressedHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<BackButtonPressedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(BackButtonPressedHandler handler) {
		handler.onBackButtonPressed(this);

	}

	public static GwtEvent.Type<BackButtonPressedHandler> getType() {
		return TYPE;
	}

}
