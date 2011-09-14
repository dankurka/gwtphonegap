package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class MenuButtonPressedEvent extends GwtEvent<MenuButtonPressedHandler> {
	public static final GwtEvent.Type<MenuButtonPressedHandler> TYPE = new Type<MenuButtonPressedHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<MenuButtonPressedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(MenuButtonPressedHandler handler) {
		handler.onMenuButtonPressed(this);

	}

	public static GwtEvent.Type<MenuButtonPressedHandler> getType() {
		return TYPE;
	}
}
