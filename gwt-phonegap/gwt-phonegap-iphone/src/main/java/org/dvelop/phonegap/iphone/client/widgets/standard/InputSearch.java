package org.dvelop.phonegap.iphone.client.widgets.standard;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Created by IntelliJ IDEA.
 * User: chem
 * Date: 26.05.2010
 * Time: 22:30:51
 * To change this template use File | Settings | File Templates.
 */
public class InputSearch extends TextBox {

    public InputSearch( ){
        this( "", 0, false);    
    }

    public InputSearch( String placeholder, int results, boolean incremental){
        super( Document.get().createTextInputElement());
        super.getElement().setAttribute("type", "search");

        if( placeholder != null && !placeholder.equals(""))
            super.getElement().setAttribute("placeholder", placeholder);

        if( results > 0){
            super.getElement().setAttribute("results", String.valueOf(results));   
        }

        if( incremental){
            super.getElement().setAttribute("incremental", "1"); 
        }
    }
}
