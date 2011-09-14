package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface OffLineHandler extends EventHandler {
	public void onOffLine(OffLineEvent event);
}
