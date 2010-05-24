package org.dvelop.phonegap.iphone.client.widgets.list;

import com.google.gwt.event.logical.shared.SelectionEvent;

/**
 * User: daniel kurka
 * Date: 24.05.2010
 * Time: 16:08:17
 */
public class ListSelectionEvent extends SelectionEvent<ListModel> {


    public ListSelectionEvent(ListModel selectedItem) {
        super(selectedItem);
    }


}