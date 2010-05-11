package org.dvelop.phonegap.iphone.client.widgets.buttons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 09:34:20
 */
public interface ButtonResourceBundle extends ClientBundle{
    public static final ButtonResourceBundle INSTANCE = GWT.create(ButtonResourceBundle.class);

    @Source("org/dvelop/phonegap/iphone/public/css/buttons.css")
    ButtonCssResource css();
}
