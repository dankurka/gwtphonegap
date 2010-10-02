package org.dvelop.phonegap.iphone.client.widgets.list;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import org.dvelop.phonegap.iphone.client.widgets.standard.StandardIphoneBundle;


/**
 * Created by IntelliJ IDEA.
 * User: christian hemker
 * Date: 22.05.2010
 * Time: 19:09:34
 */
public class ListViewPanel extends Composite {

    private FlowPanel main;
    private ListTag listTag;

    public ListViewPanel() {
        StandardIphoneBundle.INSTANCE.css().ensureInjected();
        ListViewPanelCssBundle.INSTANCE.css().ensureInjected();

        main = new FlowPanel();

        String styleName = ListViewPanelCssBundle.INSTANCE.css().listviewClass();
        main.setStyleName(styleName);

        listTag = new ListTag();
        main.add(listTag);

        initWidget(main);
    }

    public void addItem(ListElement listElement) {

        listTag.add(listElement);
    }

    public void removeItem(ListElement listElement) {
        listTag.remove(listElement);
    }

    public void remove(int index) {
        listTag.remove(index);
    }

    public int getChildrenCount() {
        return listTag.getWidgetCount();
    }


    public void clear() {
        listTag.clear();
    }


    private class ListTag extends ComplexPanel {
        public ListTag() {
            setElement(DOM.createElement("ul"));
        }

        /**
         * Adds a new child widget to the panel.
         *
         * @param w the widget to be added
         */
        @Override
        public void add(Widget w) {
            add(w, getElement());
        }

        /**
         * Inserts a widget before the specified index.
         *
         * @param w           the widget to be inserted
         * @param beforeIndex the index before which it will be inserted
         * @throws IndexOutOfBoundsException if <code>beforeIndex</code> is out of range
         */
        public void insert(Widget w, int beforeIndex) {
            insert(w, getElement(), beforeIndex, true);
        }
    }


}