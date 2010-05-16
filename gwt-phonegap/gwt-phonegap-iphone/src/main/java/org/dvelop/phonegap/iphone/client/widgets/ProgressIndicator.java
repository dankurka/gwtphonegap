package org.dvelop.phonegap.iphone.client.widgets;

import com.google.gwt.user.client.ui.RootPanel;
import org.dvelop.phonegap.iphone.client.widgets.base.IPhoneWidget;
import org.dvelop.phonegap.iphone.client.widgets.css.StandardResourceBundle;

/**
 * User: daniel kurka
 * Date: 16.05.2010
 * Time: 17:26:58
 */
public class ProgressIndicator extends IPhoneWidget {
    private IPhoneWidget widget;

    public ProgressIndicator() {
        super("div");
        StandardResourceBundle.INSTANCE.css().ensureInjected();
        setStyleName(StandardResourceBundle.INSTANCE.css().progressIndicatorClass());

        widget = new IPhoneWidget("div");
        widget.setStyleName(StandardResourceBundle.INSTANCE.css().progressIndicatorTextClass());
    }

    public void onAttach() {
        super.onAttach();
        getElement().appendChild(widget.getElement());
    }

    public void onDetach() {
        super.onDetach();
        getElement().removeChild(widget.getElement());
    }


    public String getText() {
        return widget.getElement().getInnerText();
    }

    public void setText(String text) {
        widget.getElement().setInnerText(text);
    }

    public void show() {
        if (!this.isAttached())
            RootPanel.get().add(this);
    }

    public void hide() {
        if (this.isAttached())
            RootPanel.get().remove(this);
    }
}
