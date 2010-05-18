/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.transition;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public abstract class TransitionEvent<H extends EventHandler> extends DomEvent<H> {
	private NativeTransitionEvent nativeTransitionEvent;

	public TransitionEvent(NativeTransitionEvent nativeTransitionEvent) {
		this.nativeTransitionEvent = nativeTransitionEvent;
	}

	public NativeTransitionEvent getNativeWebKitTransitionEvent() {
		return nativeTransitionEvent;
	}
}