package org.dvelop.phonegap.iphone.client.widgets.page;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import org.dvelop.phonegap.iphone.client.widgets.standard.StandardIphoneBundle;

import java.util.Iterator;

/**
 * User: daniel kurka
 * Date: 25.05.2010
 * Time: 00:05:06
 */
public class RoundPage extends Composite implements HasWidgets{

    private FlowPanel panel;

    public RoundPage(){
        StandardIphoneBundle.INSTANCE.css().ensureInjected();
        panel = new FlowPanel();
        initWidget(panel);
        panel.addStyleName(StandardIphoneBundle.INSTANCE.css().roundPageClass());
    }

    public void add(Widget w) {
        panel.add(w);
    }

    public void clear() {
        panel.clear();
    }

    public Iterator<Widget> iterator() {
        return panel.iterator();
    }

    public boolean remove(Widget w) {
        return panel.remove(w);
    }
}
