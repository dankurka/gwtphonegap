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
package com.googlecode.gwtphonegap.client.file.browser;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileObject;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.ReaderCallback;
import com.googlecode.gwtphonegap.client.file.browser.service.FileSystemController;


public class FileReaderBrowserImpl implements FileReader {

	private final FileSystemController controller;
	protected String result;
	private int state;
	private FileError error;
	private ReaderCallback<FileReader> onLoadStartCallback;
	private ReaderCallback<FileReader> onloadCallback;
	private ReaderCallback<FileReader> onAbortCallback;
	private ReaderCallback<FileReader> onErrorCallback;
	private ReaderCallback<FileReader> onLoadEndCallback;
	private boolean abort;

	public FileReaderBrowserImpl(FileSystemController controller) {
		this.controller = controller;
		this.state = FileReader.EMPTY;
		this.abort = false;
	}

	@Override
	public int getReadyState() {
		return state;
	}

	@Override
	public String getResult() {
		return result;
	}

	@Override
	public FileError getError() {
		return error;
	}

	@Override
	public void setOnLoadStartCallback(ReaderCallback<FileReader> callback) {
		this.onLoadStartCallback = callback;

	}

	@Override
	public void setOnProgressCallback(ReaderCallback<FileReader> callback) {

	}

	@Override
	public void setOnloadCallback(ReaderCallback<FileReader> callback) {
		this.onloadCallback = callback;

	}

	@Override
	public void setOnAbortCallback(ReaderCallback<FileReader> callback) {
		this.onAbortCallback = callback;

	}

	@Override
	public void setOnErrorCallback(ReaderCallback<FileReader> callback) {
		this.onErrorCallback = callback;

	}

	@Override
	public void setOnLoadEndCallback(ReaderCallback<FileReader> callback) {
		this.onLoadEndCallback = callback;

	}

	@Override
	public void abort() {
		this.abort = true;
		if (onAbortCallback != null)
			onAbortCallback.onCallback(this);

	}

	@Override
	public void readAsDataUrl(FileObject entry) {
		if (this.state == FileReader.LOADING)
			throw new RuntimeException("this loader is loading, cant do two things at once");
		this.state = FileReader.LOADING;

		if (onLoadStartCallback != null) {
			onLoadStartCallback.onCallback(this);
		}

		controller.readAsDataUrl(entry, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				if (abort)
					return;
				state = FileReader.DONE;

				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					error = fileErrorException;
				} else {
					error = new FileErrorException();
				}

				if (onErrorCallback != null) {
					onErrorCallback.onCallback(FileReaderBrowserImpl.this);
				}

				if (onLoadEndCallback != null) {
					onLoadEndCallback.onCallback(FileReaderBrowserImpl.this);
				}

			}

			@Override
			public void onSuccess(String result) {
				if (abort)
					return;
				state = FileReader.DONE;
				FileReaderBrowserImpl.this.result = result;

				if (onloadCallback != null) {
					onloadCallback.onCallback(FileReaderBrowserImpl.this);
				}

				if (onLoadEndCallback != null) {
					onLoadEndCallback.onCallback(FileReaderBrowserImpl.this);
				}
			}
		});

	}

	@Override
	public void readAsText(FileObject entry) {
		if (this.state == FileReader.LOADING)
			throw new RuntimeException("this loader is loading, cant do two things at once");
		this.state = FileReader.LOADING;

		if (onLoadStartCallback != null) {
			onLoadStartCallback.onCallback(this);
		}

		controller.readAsText(entry, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				if (abort)
					return;
				state = FileReader.DONE;

				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					error = fileErrorException;
				} else {
					error = new FileErrorException();
				}

				if (onErrorCallback != null) {
					onErrorCallback.onCallback(FileReaderBrowserImpl.this);
				}

				if (onLoadEndCallback != null) {
					onLoadEndCallback.onCallback(FileReaderBrowserImpl.this);
				}

			}

			@Override
			public void onSuccess(String result) {
				if (abort)
					return;
				state = FileReader.DONE;
				FileReaderBrowserImpl.this.result = result;

				if (onloadCallback != null) {
					onloadCallback.onCallback(FileReaderBrowserImpl.this);
				}

				if (onLoadEndCallback != null) {
					onLoadEndCallback.onCallback(FileReaderBrowserImpl.this);
				}
			}
		});

	}

}
