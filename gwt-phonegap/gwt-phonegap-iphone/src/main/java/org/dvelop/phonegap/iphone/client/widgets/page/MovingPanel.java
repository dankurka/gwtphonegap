package org.dvelop.phonegap.iphone.client.widgets.page;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

import java.util.Iterator;

/**
 * User: daniel kurka
 * Date: 24.05.2010
 * Time: 14:24:39
 */
public class MovingPanel extends Composite implements HasWidgets {
    private FlowPanel main;

    public MovingPanel() {
        main = new FlowPanel();
        initWidget(main);
        BasicPageResourceBundle.INSTANCE.css().ensureInjected();
        main.setStyleName(BasicPageResourceBundle.INSTANCE.css().movingPanel());
    }


    public void add(Widget w) {
        main.add(w);
    }

    public void clear() {
        main.clear();
    }

    public Iterator<Widget> iterator() {
        return main.iterator();
    }

    public boolean remove(Widget w) {
        return main.remove(w);
    }
}
