/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import com.googlecode.gwtphonegap.client.file.FileDownloadCallback;
import com.googlecode.gwtphonegap.client.file.FileTransfer;
import com.googlecode.gwtphonegap.client.file.FileUploadCallback;
import com.googlecode.gwtphonegap.client.file.FileUploadOptions;
import com.googlecode.gwtphonegap.collection.client.JsLightMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class FileTransferJsImpl extends JavaScriptObject implements FileTransfer {

  protected FileTransferJsImpl() {

  }

  @Override
  public native void abort()/*-{
		this.abort();
  }-*/;

  @Override
  public void download(String sourceUrl, String filePath, FileDownloadCallback callback) {
    download0(sourceUrl, filePath, callback);
  }

  @Override
  public void upload(String fileUri, String serverUrl, FileUploadOptions options,
      FileUploadCallback callback) {
    Map<String, String> params = options.getParams();
    JsLightMap<String> map = new JsLightMap<String>();
    if (params != null && params.size() > 0) {
      Set<Entry<String, String>> entrySet = params.entrySet();
      for (Entry<String, String> entry : entrySet) {
        map.put(entry.getKey(), entry.getValue());
      }
    }

    Map<String, String> head = options.getHeaders();
    JsLightMap<String> headers = new JsLightMap<String>();
    if (head != null && head.size() > 0) {
      Set<Entry<String, String>> entrySet = head.entrySet();
      for (Entry<String, String> entry : entrySet) {
        headers.put(entry.getKey(), entry.getValue());
      }
    }

    upload0(fileUri, serverUrl, options, map.getMap(), headers.getMap(), callback);

  }

  private native void upload0(String fileUri, String serverUrl, FileUploadOptions options,
      JavaScriptObject map, JavaScriptObject headers, FileUploadCallback callback)/*-{
		var that = this;

		var suc = function(result) {
			callback.@com.googlecode.gwtphonegap.client.file.FileUploadCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/file/FileUploadResult;)(result);
		};

		var fail = function(error) {
			callback.@com.googlecode.gwtphonegap.client.file.FileUploadCallback::onFailure(Lcom/googlecode/gwtphonegap/client/file/FileTransferError;)(error);
		};

		this.onprogress = $entry(function(progressEvent) {
			callback.@com.googlecode.gwtphonegap.client.file.FileUploadCallback::onProgress(Lcom/googlecode/gwtphonegap/client/file/FileTransferProgressEvent;)(progressEvent);
		});

		var fop = new $wnd.FileUploadOptions();

		fop.fileKey = options.@com.googlecode.gwtphonegap.client.file.FileUploadOptions::getFileKey()();
		fop.fileName = options.@com.googlecode.gwtphonegap.client.file.FileUploadOptions::getFileName()();
		fop.mimeType = options.@com.googlecode.gwtphonegap.client.file.FileUploadOptions::getMimeType()();
		fop.params = map;
		fop.headers = headers;

		this.upload(fileUri, serverUrl, $entry(suc), $entry(fail), fop);
  }-*/;

  private native void download0(String sourceUrl, String filePath, FileDownloadCallback callback)/*-{

		var suc = function(result) {
			var en = @com.googlecode.gwtphonegap.client.file.js.FileEntryJsImpl::new(Lcom/google/gwt/core/client/JavaScriptObject;)(result);
			callback.@com.googlecode.gwtphonegap.client.file.FileDownloadCallback::onSuccess(Lcom/googlecode/gwtphonegap/client/file/FileEntry;)(en);
		};

		var fail = function(error) {
			callback.@com.googlecode.gwtphonegap.client.file.FileDownloadCallback::onFailure(Lcom/googlecode/gwtphonegap/client/file/FileTransferError;)(error);
		};
		this.onprogress = $entry(function(progressEvent) {
			callback.@com.googlecode.gwtphonegap.client.file.FileDownloadCallback::onProgress(Lcom/googlecode/gwtphonegap/client/file/FileTransferProgressEvent;)(progressEvent);
		});
		this.download(sourceUrl, filePath, $entry(suc), $entry(fail));
  }-*/;

}
