/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.transition;


/**
 * @author mchrist
 *
 */
public class TransitionEndEvent extends TransitionEvent<TransitionEndHandler> {
	private static final Type<TransitionEndHandler> TYPE = new Type<TransitionEndHandler>(
			"webkittransitionend", new TransitionEndEvent(null));

	public TransitionEndEvent(NativeTransitionEvent nativeTransitionEvent) {
		super(nativeTransitionEvent);
	}

	@Override
	public Type<TransitionEndHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(TransitionEndHandler handler) {
		handler.onWebKitTransitionEndHandler();
	}

	public static Type<TransitionEndHandler> getType() {
		return TYPE;
	}

}