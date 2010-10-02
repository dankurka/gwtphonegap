package org.dvelop.phonegap.iphone.client.widgets.list;

import com.google.gwt.user.client.ui.HasText;
import org.dvelop.phonegap.iphone.client.widgets.base.SimpleTouchWidget;
import org.dvelop.phonegap.iphone.client.widgets.base.TouchableIPhoneWidget;

public class ListElement  extends SimpleTouchWidget implements HasText {
    public ListElement() {
        super("li");
    }

    public String getText() {
        return getElement().getInnerHTML();
    }

    public void setText(String text) {
        getElement().setInnerHTML(text);
    }

    public void setClickable(boolean b) {
        if(b){
          addStyleName(ListViewPanelCssBundle.INSTANCE.css().groupClass());
       }else{
          removeStyleName(ListViewPanelCssBundle.INSTANCE.css().groupClass());
       }
   }
}