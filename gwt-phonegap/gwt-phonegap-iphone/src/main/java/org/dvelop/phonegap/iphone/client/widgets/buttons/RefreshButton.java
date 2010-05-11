package org.dvelop.phonegap.iphone.client.widgets.buttons;

import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;

/**
 * User: daniel kurka
 * Date: 11.05.2010
 * Time: 09:29:03
 */
public class RefreshButton extends IPhoneWidget{
    public RefreshButton() {
        super("div");
        ButtonResourceBundle.INSTANCE.css().ensureInjected();
        setStyleName(ButtonResourceBundle.INSTANCE.css().refreshButtonClass());
    }
}
