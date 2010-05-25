package org.dvelop.phonegap.iphone.client.widgets.list;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import org.dvelop.phonegap.iphone.client.widgets.event.touch.SimpleTouchHandler;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chem
 * Date: 22.05.2010
 * Time: 20:31:58
 * To change this template use File | Settings | File Templates.
 */
public class SimpleList extends Composite implements HasListSelectionHandler {

    private ListViewPanel listPanel;

    private List<ListModel> items;

    public SimpleList() {

        listPanel = new ListViewPanel();

        initWidget(listPanel);
    }

    public void displayItems(List<ListModel> itemsList) {
        this.items = itemsList;

        listPanel.clear();
        if (items.size() < 1) {
            ListElement listElement = new ListElement();
            listElement.setText("No Elements");
            listPanel.addItem(listElement);
        } else {
            for (int i = 0; i < itemsList.size(); i++) {
                ListModel model = itemsList.get(i);
                ListElement listElement = new ListElement();
                listElement.addStyleName(ListViewPanelCssBundle.INSTANCE.css().multilineClass());

                StringBuffer buffer = new StringBuffer();

                if (model.markUnread()) {
                    buffer.append("<div class='" + ListViewPanelCssBundle.INSTANCE.css().markerNewClass() + "'></div>");
                } else {
                    buffer.append("<div class='" + ListViewPanelCssBundle.INSTANCE.css().markerNoneClass() + "'></div>");
                }


                buffer.append("<div class='" + ListViewPanelCssBundle.INSTANCE.css().liueberClass() + "'>" + model.getTitle() + "</div>");
                buffer.append("<div class='" + ListViewPanelCssBundle.INSTANCE.css().liunterClass() + "'>" + model.getMessage() + "</div>");

                listElement.setText(buffer.toString());

                listElement.setClickable(true);
                listElement.addSimpleTouchHandler(new InternalTouchHandler(model));

                listPanel.addItem(listElement);
            }
        }
    }

    public void clear() {
        listPanel.clear();
    }

    private class InternalTouchHandler implements SimpleTouchHandler {
        private ListModel model;

        public InternalTouchHandler(ListModel model) {
            this.model = model;
        }

        public void onTouch() {
            fireEvent(new ListSelectionEvent(model));
        }
    }

    public HandlerRegistration addSelectionHandler(ListSelectionHandler listModelSelectionHandler) {
        return addHandler(listModelSelectionHandler, ListSelectionEvent.getType());
    }
}
