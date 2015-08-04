package com.googlecode.gwtphonegap.client.toast;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.plugins.PhoneGapPlugin;
import com.googlecode.gwtphonegap.client.toast.ToastPhoneGapImpl.ToastFailJSO;
import com.googlecode.gwtphonegap.client.toast.ToastPhoneGapImpl.ToastSuccessJSO;

public interface Toast extends PhoneGapPlugin {

	public enum ToastDuration{
	       SHORT("short"), LONG("long");
	       private String value;
	       private ToastDuration(String value) {
	            this.value = value;
	       }
	       public String getValue(){
	        return value;
	       }
	   }
	
	public enum ToastPostion{
	       TOP("top"), CENTER("center"),BOTTOM("bottom");
	       private String value;
	       private ToastPostion(String value) {
	            this.value = value;
	       }
	       public String getValue(){
	        return value;
	       }
	   }
	
	void show(String message, ToastDuration duration, ToastPostion position, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
//	duration: 'short', 'long'
//	position: 'top', 'center', 'bottom'
//	You can also use any of these convenience methods:

	void showShortTop(String message,ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
	void showShortCenter(String message,ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
	void showShortBottom(String message,ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
	void showLongTop(String message,ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
	void showLongCenter(String message,ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
	void showLongBottom(String message,ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack);
	
}
