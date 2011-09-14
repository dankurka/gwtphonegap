package de.kurka.phonegap.client.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasResumeHandlers extends HasHandlers {
	public HandlerRegistration addResumeHandler(ResumeHandler handler);
}
