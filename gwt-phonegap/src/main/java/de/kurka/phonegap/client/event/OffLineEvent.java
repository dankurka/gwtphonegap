package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class OffLineEvent extends GwtEvent<OffLineHandler> {

	public static final GwtEvent.Type<OffLineHandler> TYPE = new Type<OffLineHandler>();

	public OffLineEvent() {
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<OffLineHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(OffLineHandler handler) {
		handler.onOffLine(this);

	}

	public static GwtEvent.Type<OffLineHandler> getType() {
		return TYPE;
	}

}
