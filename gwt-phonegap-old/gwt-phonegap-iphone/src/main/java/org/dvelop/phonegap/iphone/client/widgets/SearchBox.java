package org.dvelop.phonegap.iphone.client.widgets;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.*;
import com.google.gwt.event.shared.*;
import com.google.gwt.user.client.ui.*;
import org.dvelop.phonegap.iphone.client.widgets.standard.*;

/**
 * User: daniel kurka
 * Date: 30.05.2010
 * Time: 18:34:45
 */
public class SearchBox extends Composite implements HasChangeHandlers, HasText, HasName, HasValue<String>, HasPlaceHolder{
    private TextBox box;

    public SearchBox() {
        StandardIPhoneCssResource resource = StandardIphoneBundle.INSTANCE.css();
        resource.ensureInjected();


        FlowPanel main = new FlowPanel();
        main.addStyleName(resource.searchBoxClass());

        initWidget(main);

        FlowPanel secondDiv = new FlowPanel();
        main.add(secondDiv);

        box = new TextBox();
        box.addStyleName(resource.selectAbleClass());

        box.getElement().setAttribute("autocapitalize", "off");
        box.getElement().setAttribute("autocorrect", "off");

        secondDiv.add(box);


    }

    public void setPlaceHolder(String text){
        box.getElement().setAttribute("placeholder", text);       
    }

    public String getPlaceHolder(){
        return box.getElement().getAttribute("placeholder");
    }

    public String getText() {
        return box.getText();
    }

    public void setText(String text) {
        box.setText(text);
    }

    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> stringValueChangeHandler) {
        return box.addValueChangeHandler(stringValueChangeHandler);
    }



    public void setName(String name) {
        box.setName(name);
    }

    public String getName() {
        return box.getName();
    }

    public HandlerRegistration addChangeHandler(ChangeHandler handler) {
        return box.addChangeHandler(handler);
    }

    public String getValue() {
        return box.getValue();
    }

    public void setValue(String value) {
        box.setValue(value);
    }

    public void setValue(String value, boolean fireEvents) {
        box.setValue(value, fireEvents);
    }
}
