package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class OnlineEvent extends GwtEvent<OnlineHandler> {

	public static final GwtEvent.Type<OnlineHandler> TYPE = new Type<OnlineHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<OnlineHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OnlineHandler handler) {
		handler.onOnlineEvent(this);

	}

	public static GwtEvent.Type<OnlineHandler> getType() {
		return TYPE;
	}

}
