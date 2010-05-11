package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.user.client.ui.HasText;
import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;


/**
 *
 * User: daniel kurka
 * Date: 17.02.2010
 * Time: 22:47:36
 *
 */
public class Title extends IPhoneWidget implements HasText {

    public Title() {
        super("div");
        HeaderPanelResourceBundle.INSTANCE.css().ensureInjected();
        setStyleName(HeaderPanelResourceBundle.INSTANCE.css().titleClass());
    }

    public String getText() {
        return getElement().getInnerText();
    }

    public void setText(String text) {
        getElement().setInnerText(text);
    }
}