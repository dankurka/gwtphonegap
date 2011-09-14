package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasSearchButtonHandlers extends HasHandlers {
	public HandlerRegistration addSearchButtonHandler(SearchButtonPressedHandler handler);
}
