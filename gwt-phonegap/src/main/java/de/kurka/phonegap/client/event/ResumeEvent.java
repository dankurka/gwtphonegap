package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ResumeEvent extends GwtEvent<ResumeHandler> {

	public static final GwtEvent.Type<ResumeHandler> TYPE = new Type<ResumeHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ResumeHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ResumeHandler handler) {
		handler.onResumeEvent(this);

	}

	public static GwtEvent.Type<ResumeHandler> getType() {
		return TYPE;
	}

}
