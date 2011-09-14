package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.HandlerRegistration;

public interface HasMenuButtonPressedHandlers {
	public HandlerRegistration addMenuButtonPressedHandler(MenuButtonPressedHandler handler);
}
