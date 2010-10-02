/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public interface TouchEndHandler extends EventHandler {

	void onTouchEnd(TouchEndEvent touchEndEvent);

}