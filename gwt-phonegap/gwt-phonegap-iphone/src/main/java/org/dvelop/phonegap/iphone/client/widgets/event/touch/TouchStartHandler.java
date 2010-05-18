/**
 * 
 */
package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author mchrist
 *
 */
public interface TouchStartHandler extends EventHandler {

	void onTouchStart(TouchStartEvent touchStartEvent);

}