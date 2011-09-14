package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasOnlineHandler extends HasHandlers {
	public HandlerRegistration addOnlineHandler(OnlineHandler handler);
}
