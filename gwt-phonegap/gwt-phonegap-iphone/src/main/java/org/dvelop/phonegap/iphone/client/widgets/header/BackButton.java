package org.dvelop.phonegap.iphone.client.widgets.header;

import com.google.gwt.user.client.ui.HasText;
import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchableIPhoneWidget;


/**
 * User: daniel kurka
 * Date: 17.02.2010
 * Time: 22:42:30
 */
public class BackButton extends TouchableIPhoneWidget implements HasText{

    public BackButton() {
        super("div");
        HeaderPanelResourceBundle.INSTANCE.css().ensureInjected();
        setStyleName(HeaderPanelResourceBundle.INSTANCE.css().backButtonClass());
    }

    public String getText() {
		return getElement().getInnerText();
	}

	public void setText(String text) {
		getElement().setInnerText(text);
	}
}