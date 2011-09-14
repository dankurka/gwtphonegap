package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasOfflineHandler extends HasHandlers {
	public HandlerRegistration addOfflineHandler(OffLineHandler handler);
}
