package org.dvelop.phonegap.iphone.client.widgets.list;

/**
 * User: daniel kurka
 * Date: 24.05.2010
 * Time: 16:08:01
 */
public interface ListModel {

    public String getTitle();

    public String getMessage();

    public boolean markUnread();

    public boolean isSelectable();


}
