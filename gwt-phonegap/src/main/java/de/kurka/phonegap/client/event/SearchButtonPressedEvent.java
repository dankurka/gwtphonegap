package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class SearchButtonPressedEvent extends GwtEvent<SearchButtonPressedHandler> {

	public static final GwtEvent.Type<SearchButtonPressedHandler> TYPE = new Type<SearchButtonPressedHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<SearchButtonPressedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(SearchButtonPressedHandler handler) {
		handler.onSearchButtonPressed(this);

	}

	public static GwtEvent.Type<SearchButtonPressedHandler> getType() {
		return TYPE;
	}

}
