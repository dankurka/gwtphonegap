/*
 * Copyright 2010 Daniel Kurka
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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.thirdparty.streamhtmlparser.JavascriptParser;
import com.googlecode.gwtphonegap.client.file.*;

public final class FileReaderJsImpl extends JavaScriptObject implements FileReader {

	protected FileReaderJsImpl() {

	}

	@Override
	public native int getReadyState() /*-{
		return this.readyState;
	}-*/;

	@Override
	public native String getResult() /*-{
		return this.result;
	}-*/;

	@Override
	public native FileError getError() /*-{
		return this.error;
	}-*/;

	@Override
	public native void setOnLoadStartCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@com.googlecode.gwtphonegap.client.file.js.FileReaderJsImpl::onCallback(Lcom/googlecode/gwtphonegap/client/file/ReaderCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onloadstart = $entry(func);

	}-*/;

	@Override
	public native void setOnProgressCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@com.googlecode.gwtphonegap.client.file.js.FileReaderJsImpl::onCallback(Lcom/googlecode/gwtphonegap/client/file/ReaderCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onprogress = $entry(func);

	}-*/;

	@Override
	public native void setOnLoadCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@com.googlecode.gwtphonegap.client.file.js.FileReaderJsImpl::onCallback(Lcom/googlecode/gwtphonegap/client/file/ReaderCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onload = $entry(func);

	}-*/;

	@Override
	public native void setOnAbortCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@com.googlecode.gwtphonegap.client.file.js.FileReaderJsImpl::onCallback(Lcom/googlecode/gwtphonegap/client/file/ReaderCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onabort = $entry(func);

	}-*/;

	@Override
	public native void setOnErrorCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@com.googlecode.gwtphonegap.client.file.js.FileReaderJsImpl::onCallback(Lcom/googlecode/gwtphonegap/client/file/ReaderCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onerror = $entry(func);

	}-*/;

	@Override
	public native void setOnLoadEndCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@com.googlecode.gwtphonegap.client.file.js.FileReaderJsImpl::onCallback(Lcom/googlecode/gwtphonegap/client/file/ReaderCallback;Lcom/googlecode/gwtphonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onloadend = $entry(func);

	}-*/;

	private static void onCallback(ReaderCallback<FileReader> callback, FileReaderJsImpl reader) {
		callback.onCallback(reader);
	}

	@Override
	public native void abort()/*-{
		this.abort();
	}-*/;

	@Override
	public void readAsDataUrl(FileEntry entry) {
		FileEntryJsImpl entryJs = (FileEntryJsImpl) entry;
		readAsDataUrl0(entryJs.getEntry());

	}

	private native void readAsDataUrl0(JavaScriptObject entry)/*-{
		this.readAsDataURL(entry);
	}-*/;

	@Override
	public void readAsText(FileEntry entry,final String encoding) {
		FileEntryJsImpl entryJs = (FileEntryJsImpl) entry;
		entryJs.getFile(new FileCallback<FileObject, FileError>() {
            @Override
            public void onSuccess(FileObject entry) {
                readAsText0(entry,encoding);
            }
            @Override
            public void onFailure(FileError error) {

            }
        });
	}

    private native void readAsText0(FileObject entry,String encoding)/*-{
		this.readAsText(entry);
	}-*/;

    @Override
    public void readAsBinaryString(FileEntry entry) {
        FileEntryJsImpl entryJs = (FileEntryJsImpl)entry;
        readAsBinaryString0(entryJs.getEntry());
    }

    private native void readAsBinaryString0(JavaScriptObject entry)/*-{
        this.readAsBinaryString(entry);
    }-*/;

    @Override
    public void readAsArrayBuffer(FileEntry entry) {
        FileEntryJsImpl entryJs = (FileEntryJsImpl)entry;
        readAsBinaryString0(entryJs.getEntry());
    }

    private native void readAsArrayBuffer0(JavascriptParser entry)/*-{
    this.readAsArrayBuffer(entry);
    }-*/;

}
