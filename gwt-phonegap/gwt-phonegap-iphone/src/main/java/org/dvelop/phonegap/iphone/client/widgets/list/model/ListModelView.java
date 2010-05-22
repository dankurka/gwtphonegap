package org.dvelop.phonegap.iphone.client.widgets.list.model;

import com.google.gwt.user.client.ui.Composite;
import org.dvelop.phonegap.iphone.client.widgets.list.ListElement;
import org.dvelop.phonegap.iphone.client.widgets.list.ListViewPanel;
import org.dvelop.phonegap.iphone.client.widgets.list.ListViewPanelCssBundle;
import org.dvelop.phonegap.iphone.client.widgets.list.model.ListModel;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chem
 * Date: 22.05.2010
 * Time: 20:31:58
 * To change this template use File | Settings | File Templates.
 */
public class ListModelView extends Composite {

    private ListViewPanel listPanel;

    private List<ListModel> items;

    public ListModelView() {

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
                listElement.addStyleName( ListViewPanelCssBundle.INSTANCE.css().multilineClass());

                StringBuffer buffer = new StringBuffer();
                /*
                if (model.isNewEntry()) {
                    buffer.append("<div class='markerNew'></div>");
                } else
                */
                buffer.append("<div class='"+ListViewPanelCssBundle.INSTANCE.css().markerNoneClass()+"'></div>");


                buffer.append("<div class='"+ListViewPanelCssBundle.INSTANCE.css().liueberClass()+"'>" + model.getTitle() + "</div>");
                buffer.append("<div class='"+ListViewPanelCssBundle.INSTANCE.css().liunterClass()+"'>" + model.getDetail() + "</div>");

                listElement.setText(buffer.toString());

                listElement.setClickable(true);
                // listElement.addHandler(new MyTouchHander(i));

                listPanel.addItem(listElement);
            }
        }
    }
}
