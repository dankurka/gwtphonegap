package org.dvelop.phonegap.iphone.client.widgets.list.model;

/**
 * Created by IntelliJ IDEA.
 * User: chem
 * Date: 22.05.2010
 * Time: 20:35:06
 * To change this template use File | Settings | File Templates.
 */
public class ListModel {
    private String title;
    private String detail;

    public ListModel( String title, String detail){
        this.title = title;
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
