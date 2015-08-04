package com.googlecode.gwtphonegap.client.toast;

public interface ToastPluginCallback<S, E>{
	public void onSuccess(S entry);

	public void onFailure(E error);
}
