package de.kurka.phonegap.client;

import com.google.gwt.event.shared.GwtEvent;

public class PhoneGapTimeoutEvent extends GwtEvent<PhoneGapTimeoutHandler> {

	public static final GwtEvent.Type<PhoneGapTimeoutHandler> TYPE = new Type<PhoneGapTimeoutHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PhoneGapTimeoutHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PhoneGapTimeoutHandler handler) {
		handler.onPhoneGapTimeout(this);

	}

}
