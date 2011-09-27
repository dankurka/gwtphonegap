package com.googlecode.gwtphonegap.client.file.js;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileTransfer;
import com.googlecode.gwtphonegap.client.file.FileUploadCallback;
import com.googlecode.gwtphonegap.client.file.FileUploadOptions;

import de.kurka.gwt.collection.client.JsLightMap;

public final class FileTransferJsImpl extends JavaScriptObject implements FileTransfer {

	protected FileTransferJsImpl() {

	}

	@Override
	public void upload(String fileUri, String serverUrl, FileUploadOptions options, FileUploadCallback callback) {
		Map<String, String> params = options.getParams();
		JsLightMap<String> map = new JsLightMap<String>();
		if (params != null && params.size() > 0) {
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				map.put(entry.getKey(), entry.getValue());
			}
		}

		upload0(fileUri, serverUrl, options, map.getMap(), callback);

	}

	private native void upload0(String fileUri, String serverUrl, FileUploadOptions options, JavaScriptObject map, FileUploadCallback callback)/*-{
		var that = this;

		var suc = function(result) {
			callback.@com.googlecode.gwtphonegap.client.file.FileUploadCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/file/FileUploadResult;)(result);
		};

		var fail = function(error) {
			callback.@com.googlecode.gwtphonegap.client.file.FileUploadCallback::onFailure(Lcom/googlecode/gwtphonegap/client/file/FileTransferError;)(error);
		};

		var fop = new $wnd.FileUploadOptions();

		fop.fileKey = options.@com.googlecode.gwtphonegap.client.file.FileUploadOptions::getFileKey()();
		fop.fileName = options.@com.googlecode.gwtphonegap.client.file.FileUploadOptions::getFileName()();
		fop.mimeType = options.@com.googlecode.gwtphonegap.client.file.FileUploadOptions::getMimeType()();
		fop.params = map;

		this.upload(fileUri, serverUrl, $entry(suc), $entry(fail), fop);
	}-*/;

}
