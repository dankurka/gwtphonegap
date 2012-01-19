/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.file.js;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileTransfer;
import com.googlecode.gwtphonegap.client.file.FileUploadCallback;
import com.googlecode.gwtphonegap.client.file.FileUploadOptions;
import com.googlecode.gwtphonegap.collection.client.JsLightMap;

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
