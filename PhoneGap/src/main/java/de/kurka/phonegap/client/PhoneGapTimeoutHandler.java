package de.kurka.phonegap.client;

import com.google.gwt.event.shared.EventHandler;

public interface PhoneGapTimeoutHandler extends EventHandler {
	public void onPhoneGapTimeout(PhoneGapTimeoutEvent event);
}
