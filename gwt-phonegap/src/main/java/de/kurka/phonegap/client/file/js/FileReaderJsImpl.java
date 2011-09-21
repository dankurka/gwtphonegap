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
package de.kurka.phonegap.client.file.js;

import com.google.gwt.core.client.JavaScriptObject;

import de.kurka.phonegap.client.file.FileEntry;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileReader;
import de.kurka.phonegap.client.file.ReaderCallback;

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
			@de.kurka.phonegap.client.file.js.FileReaderJsImpl::onCallback(Lde/kurka/phonegap/client/file/ReaderCallback;Lde/kurka/phonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onloadstart = $entry(func);

	}-*/;

	@Override
	public native void setOnProgressCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@de.kurka.phonegap.client.file.js.FileReaderJsImpl::onCallback(Lde/kurka/phonegap/client/file/ReaderCallback;Lde/kurka/phonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onprogress = $entry(func);

	}-*/;

	@Override
	public native void setOnloadCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@de.kurka.phonegap.client.file.js.FileReaderJsImpl::onCallback(Lde/kurka/phonegap/client/file/ReaderCallback;Lde/kurka/phonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onload = $entry(func);

	}-*/;

	@Override
	public native void setOnAbortCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@de.kurka.phonegap.client.file.js.FileReaderJsImpl::onCallback(Lde/kurka/phonegap/client/file/ReaderCallback;Lde/kurka/phonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onabort = $entry(func);

	}-*/;

	@Override
	public native void setOnErrorCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@de.kurka.phonegap.client.file.js.FileReaderJsImpl::onCallback(Lde/kurka/phonegap/client/file/ReaderCallback;Lde/kurka/phonegap/client/file/js/FileReaderJsImpl;)(callback, that);
		};

		this.onerror = $entry(func);

	}-*/;

	@Override
	public native void setOnLoadEndCallback(ReaderCallback<FileReader> callback) /*-{
		var that = this;
		var func = function() {
			@de.kurka.phonegap.client.file.js.FileReaderJsImpl::onCallback(Lde/kurka/phonegap/client/file/ReaderCallback;Lde/kurka/phonegap/client/file/js/FileReaderJsImpl;)(callback, that);
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
		readAsDataUrl(entryJs);

	}

	private native void readAsDataUrl(JavaScriptObject entry)/*-{
		this.readAsDataUrl(entry);
	}-*/;

	@Override
	public void readAsText(FileEntry entry) {
		FileEntryJsImpl entryJs = (FileEntryJsImpl) entry;
		readAsText(entryJs);
	}

	private native void readAsText(JavaScriptObject entry)/*-{
		this.readAsText(entry);
	}-*/;

}
