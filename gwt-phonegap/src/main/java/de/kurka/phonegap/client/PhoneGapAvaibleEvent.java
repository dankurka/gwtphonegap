package de.kurka.phonegap.client;

import com.google.gwt.event.shared.GwtEvent;

public class PhoneGapAvaibleEvent extends GwtEvent<PhoneGapAvaibleHandler> {

	public static final GwtEvent.Type<PhoneGapAvaibleHandler> TYPE = new GwtEvent.Type<PhoneGapAvaibleHandler>();

	public PhoneGapAvaibleEvent() {

	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<PhoneGapAvaibleHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PhoneGapAvaibleHandler handler) {
		handler.onPhoneGapAvaible(this);

	}

}
