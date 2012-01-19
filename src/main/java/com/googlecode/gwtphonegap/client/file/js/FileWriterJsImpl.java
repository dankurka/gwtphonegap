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

import com.google.gwt.core.client.JavaScriptObject;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileWriter;
import com.googlecode.gwtphonegap.client.file.WriterCallback;

public class FileWriterJsImpl implements FileWriter {

	private final JavaScriptObject writer;

	public FileWriterJsImpl(JavaScriptObject writer) {
		this.writer = writer;
	}

	public JavaScriptObject getWriter() {
		return writer;
	}

	@Override
	public native int getReadyState() /*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer).readyState;
	}-*/;

	@Override
	public native String getFileName() /*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer).fileName;
	}-*/;

	@Override
	public long getLength() {
		return Math.round(getLength0());
	}

	private native double getLength0()/*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer).length;
	}-*/;

	@Override
	public long getPosition() {
		return Math.round(getPosition0());
	}

	private native double getPosition0()/*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer).position;
	}-*/;

	@Override
	public native FileError getError()/*-{
		return (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer).error;
	}-*/;

	@Override
	public native void setOnWriteStartCallback(WriterCallback<FileWriter> callback) /*-{
		var that = this;
		var cal = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::onCallBack(Lcom/googlecode/gwtphonegap/client/file/WriterCallback;)(callback);
		};
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.onwritestart = $entry(cal);
	}-*/;

	private void onCallBack(WriterCallback<FileWriter> callback) {
		callback.onCallback(this);
	}

	@Override
	public native void setOnProgressCallback(WriterCallback<FileWriter> callback) /*-{
		var that = this;
		var cal = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::onCallBack(Lcom/googlecode/gwtphonegap/client/file/WriterCallback;)(callback);
		};
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.onprogress = $entry(cal);
	}-*/;

	@Override
	public native void setOnWriteCallback(WriterCallback<FileWriter> callback)/*-{
		var that = this;
		var cal = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::onCallBack(Lcom/googlecode/gwtphonegap/client/file/WriterCallback;)(callback);
		};
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.onwrite = $entry(cal);
	}-*/;

	@Override
	public native void setOnAbortCallback(WriterCallback<FileWriter> callback) /*-{
		var that = this;
		var cal = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::onCallBack(Lcom/googlecode/gwtphonegap/client/file/WriterCallback;)(callback);
		};
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.onabort = $entry(cal);
	}-*/;

	@Override
	public native void setOnErrorCallback(WriterCallback<FileWriter> callback) /*-{
		var that = this;
		var cal = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::onCallBack(Lcom/googlecode/gwtphonegap/client/file/WriterCallback;)(callback);
		};
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.onerror = $entry(cal);
	}-*/;

	@Override
	public native void setOnWriteEndCallback(WriterCallback<FileWriter> callback) /*-{
		var that = this;
		var cal = function() {
			that.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::onCallBack(Lcom/googlecode/gwtphonegap/client/file/WriterCallback;)(callback);
		};
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.onwriteend = $entry(cal);
	}-*/;

	@Override
	public native void abort() /*-{
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.abort();
	}-*/;

	@Override
	public void seek(long position) {
		seek(position);
	}

	private native void seek(double position)/*-{
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.seek(position);
	}-*/;

	@Override
	public void truncate(long position) {
		truncate(position);
	}

	private native void truncate(double position)/*-{
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.truncate(position);
	}-*/;

	@Override
	public native void write(String text) /*-{
		var writer = (this.@com.googlecode.gwtphonegap.client.file.js.FileWriterJsImpl::writer);
		writer.write(text);
	}-*/;

}
