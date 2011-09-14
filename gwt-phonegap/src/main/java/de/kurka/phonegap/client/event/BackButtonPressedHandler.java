package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface BackButtonPressedHandler extends EventHandler {
	public void onBackButtonPressed(BackButtonPressedEvent event);
}
