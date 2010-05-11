package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.user.client.ui.HasText;
import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;

/**
 *
 * User: daniel kurka
 * Date: 20.02.2010
 * Time: 16:42:54
 */
public class ForwardButton extends IPhoneWidget implements HasText {
    public ForwardButton() {
        super("div");
        HeaderPanelResourceBundle.INSTANCE.css().ensureInjected();
        setStyleName(HeaderPanelResourceBundle.INSTANCE.css().forwardButtonClass());
    }

    public String getText() {
        return getElement().getInnerText();
    }

    public void setText(String text) {
        getElement().setInnerText(text);
    }

}