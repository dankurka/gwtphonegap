package de.kurka.phonegap.client.file.js;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.gwt.collection.client.JsLightMap;
import de.kurka.phonegap.client.file.FileTransfer;
import de.kurka.phonegap.client.file.FileUploadCallback;
import de.kurka.phonegap.client.file.FileUploadOptions;

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
			callback.@de.kurka.phonegap.client.file.FileUploadCallback::onSuccess(Lde/kurka/phonegap/client/file/FileUploadResult;)(result);
		};

		var fail = function(error) {
			callback.@de.kurka.phonegap.client.file.FileUploadCallback::onFailure(Lde/kurka/phonegap/client/file/FileTransferError;)(error);
		};

		var fop = new $wnd.FileUploadOptions();

		fop.fileKey = options.@de.kurka.phonegap.client.file.FileUploadOptions::getFileKey()();
		fop.fileName = options.@de.kurka.phonegap.client.file.FileUploadOptions::getFileName()();
		fop.mimeType = options.@de.kurka.phonegap.client.file.FileUploadOptions::getMimeType()();
		fop.params = map;

		this.upload(fileUri, serverUrl, $entry(suc), $entry(fail), fop);
	}-*/;

}
