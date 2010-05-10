package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.user.client.ui.HasText;
import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;

/**
 * Created by IntelliJ IDEA.
 * User: kurt
 * Date: 20.02.2010
 * Time: 16:42:54
 * To change this template use File | Settings | File Templates.
 */
public class ForwardButton extends IPhoneWidget implements HasText {
    public ForwardButton() {
        super("div");
        setStyleName("forwardButton");
    }

    public String getText() {
        return getElement().getInnerText();
    }

    public void setText(String text) {
        getElement().setInnerText(text);
    }

}