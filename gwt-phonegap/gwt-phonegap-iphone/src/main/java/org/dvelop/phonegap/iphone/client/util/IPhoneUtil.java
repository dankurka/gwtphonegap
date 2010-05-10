package org.dvelop.phonegap.iphone.client.util;

import com.google.gwt.dom.client.Element;

/**
 * User: daniel kurka
 * Date: 10.05.2010
 * Time: 00:06:29
 */
public class IPhoneUtil {

    public static native boolean hasTouchEvent(Element e) /*-{
		var ua = navigator.userAgent.toLowerCase();

		if (ua.indexOf("safari") != -1 && ua.indexOf("mobile") != -1 && ua.indexOf("applewebkit") != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}-*/;
}
