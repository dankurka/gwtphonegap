package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.user.client.ui.HasText;
import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;


/**
 * Created by IntelliJ IDEA.
 * User: kurt
 * Date: 17.02.2010
 * Time: 22:47:36
 * To change this template use File | Settings | File Templates.
 */
public class Title extends IPhoneWidget implements HasText {

    public Title() {
        super("div");
        setStyleName("title");
    }

    public String getText() {
        return getElement().getInnerText();
    }

    public void setText(String text) {
        getElement().setInnerText(text);
    }
}