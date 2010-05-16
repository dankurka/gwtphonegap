package org.dvelop.phonegap.iphone.client.localStorage;

/**
 * User: daniel kurka
 * Date: 15.05.2010
 * Time: 14:08:31
 *
 * implemented based on apples documentation located at:
 * http://developer.apple.com/safari/library/documentation/iPhone/Conceptual/SafariJSDatabaseGuide/Introduction/Introduction.html
 *
 */
public class LocalStorage {

    public LocalStorage() throws NoLocalStoreSupport {
        if (!testForLocalStorage()) {
            throw new NoLocalStoreSupport();
        }


    }

    public static native boolean testForLocalStorage()/*-{
        if(localStorage == null)
        {
            return false;
        }

        if(localStorage.getItem == null)
        {
            return null;
        }

        if(localStorage.setItem == null){
            return false;
        }

        if(localStorage.removeItem == null){
            return false;
        }

        return true;
    }-*/;


    public void setItem(String key, String value) throws QuotaExceededException {
        try {
            setItemNative(key, value);
        } catch (Throwable e) {
            throw new QuotaExceededException();
        }
    }


    private native void setItemNative(String key, String value) /*-{
        localStorage.setItem(key, value);
    }-*/;

    public native String getItem(String key) /*-{
        return localStorage.getItem(key);
    }-*/;

    public native void removeItem(String key) /*-{
        localStorage.removeItem(key);
    }-*/;


}
