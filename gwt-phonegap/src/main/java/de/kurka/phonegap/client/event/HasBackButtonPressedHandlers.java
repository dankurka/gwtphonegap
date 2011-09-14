package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasBackButtonPressedHandlers extends HasHandlers {
	public HandlerRegistration addBackButtonPressedHandler(BackButtonPressedHandler handler);
}
