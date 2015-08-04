package com.googlecode.gwtphonegap.client.toast;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.thirdparty.streamhtmlparser.JavascriptParser;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileDownloadCallback;

public class ToastPhoneGapImpl implements Toast {

	private boolean initialized;
	public static final String PLUGIN_ID = "nl.x-services.plugins.toast";

	private static ToastPhoneGapImpl INSTANCE;
	protected ToastPhoneGapImpl(){
		initialize();
		
	}

	@Override
	public void initialize() {
		if (!testForPlugin()) {
			throw new IllegalStateException("can not find toast plugin - did you include toast.js?");
		}
		INSTANCE = this;
		initialized = true;
	}

	private native boolean testForPlugin()/*-{
		if (!$wnd.plugins)
			return false;
		if (!$wnd.plugins.toast)
			return false;
		return true;
	}-*/;

	private native void showNative(String message, String duration, String position,
			final ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack)/*-{
		var theInstance = this;
		$wnd.plugins.toast
				.show(
						message,
						duration,
						position,
						function(a) {
							theInstance.@com.googlecode.gwtphonegap.client.toast.ToastPhoneGapImpl::onSuccess(Lcom/googlecode/gwtphonegap/client/toast/ToastPluginCallback;Lcom/googlecode/gwtphonegap/client/toast/ToastPhoneGapImpl$ToastSuccessJSO;)(callBack,a);
						},
						function(b) {
							theInstance.@com.googlecode.gwtphonegap.client.toast.ToastPhoneGapImpl::onFailure(Lcom/googlecode/gwtphonegap/client/toast/ToastPluginCallback;Lcom/googlecode/gwtphonegap/client/toast/ToastPhoneGapImpl$ToastFailJSO;)(callback,b);
						});
	}-*/;
	
	private native void showNative(String message, String duration, String position)/*-{
		$wnd.plugins.toast
				.show(
						message,
						duration,
						position,
						function(a) {
						},
						function(b) {
						});
	}-*/;

	private void onSuccess(ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack, ToastSuccessJSO entry) {
		callBack.onSuccess(entry);
	}

	private void onFailure(ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack, ToastFailJSO entry) {
		callBack.onFailure(entry);
	}

	public static class ToastSuccessJSO extends JavaScriptObject {
		protected ToastSuccessJSO() {
		}
	}

	public static class ToastFailJSO extends JavaScriptObject {
		protected ToastFailJSO() {
		}
	}

	@Override
	public void show(String message, ToastDuration duration, ToastPostion position,
			ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		if (!initialized) {
			throw new IllegalStateException("Toast Plugin not initialized");
		}
		if(callBack==null){
			showNative(message, duration.getValue(), position.getValue());
		}else{
			showNative(message, duration.getValue(), position.getValue(),callBack);
		}

	}

	@Override
	public void showShortTop(String message, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		show(message, ToastDuration.SHORT, ToastPostion.TOP, callBack);

	}

	@Override
	public void showShortCenter(String message, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		show(message, ToastDuration.SHORT, ToastPostion.CENTER, callBack);

	}

	@Override
	public void showShortBottom(String message, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		show(message, ToastDuration.SHORT, ToastPostion.BOTTOM, callBack);

	}

	@Override
	public void showLongTop(String message, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		show(message, ToastDuration.LONG, ToastPostion.TOP, callBack);

	}

	@Override
	public void showLongCenter(String message, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		show(message, ToastDuration.LONG, ToastPostion.CENTER, callBack);

	}

	@Override
	public void showLongBottom(String message, ToastPluginCallback<ToastSuccessJSO, ToastFailJSO> callBack) {
		show(message, ToastDuration.LONG, ToastPostion.BOTTOM, callBack);

	}

}
