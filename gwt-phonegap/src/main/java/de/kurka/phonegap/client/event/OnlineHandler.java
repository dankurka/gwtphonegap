package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface OnlineHandler extends EventHandler {
	public void onOnlineEvent(OnlineEvent event);
}
