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
package de.kurka.phonegap.client.file.browser;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileWriter;
import de.kurka.phonegap.client.file.WriterCallback;
import de.kurka.phonegap.client.file.browser.dto.FileWriterDTO;
import de.kurka.phonegap.client.file.browser.service.FileSystemController;

/**
 * @author Daniel Kurka
 * 
 */
public class FileWriterBrowserImpl implements FileWriter {

	private final FileSystemController controller;
	private FileWriterDTO result;
	private WriterCallback<FileWriter> onWriteStartCallback;
	private WriterCallback<FileWriter> onWriteCallback;
	private WriterCallback<FileWriter> onAbortCallback;
	private WriterCallback<FileWriter> onErrorCallback;
	private WriterCallback<FileWriter> onWriteEndCallback;

	private int status;

	private FileError error;

	private boolean abort;

	/**
	 * @param result
	 */
	public FileWriterBrowserImpl(FileWriterDTO result, FileSystemController controller) {
		this.result = result;
		this.controller = controller;
		status = FileWriter.INIT;

	}

	@Override
	public int getReadyState() {
		return status;
	}

	@Override
	public String getFileName() {
		return result.getName();
	}

	@Override
	public long getLength() {
		return result.getSize();
	}

	@Override
	public long getPosition() {
		return result.getPosition();
	}

	@Override
	public FileError getError() {
		return error;
	}

	@Override
	public void setOnWriteStartCallback(WriterCallback<FileWriter> callback) {
		this.onWriteStartCallback = callback;

	}

	@Override
	public void setOnProgressCallback(WriterCallback<FileWriter> callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOnWriteCallback(WriterCallback<FileWriter> callback) {
		this.onWriteCallback = callback;

	}

	@Override
	public void setOnAbortCallback(WriterCallback<FileWriter> callback) {
		this.onAbortCallback = callback;

	}

	@Override
	public void setOnErrorCallback(WriterCallback<FileWriter> callback) {
		this.onErrorCallback = callback;

	}

	@Override
	public void setOnWriteEndCallback(WriterCallback<FileWriter> callback) {
		this.onWriteEndCallback = callback;

	}

	@Override
	public void abort() {
		abort = true;
		if (onAbortCallback != null) {
			onAbortCallback.onCallback(this);
		}

	}

	@Override
	public void seek(long position) {
		result.setPosition(position);

	}

	@Override
	public void truncate(long position) {
		//TODO how do we implement this for devmode?
		//lets just put out a warning....
		//and fix this later
		Window.alert("truncate not working in dev mode");

	}

	@Override
	public void write(String text) {
		if (status != INIT) {
			throw new RuntimeException("this filewriter has already been used");
		}
		status = WRITING;
		if (onWriteStartCallback != null) {
			onWriteStartCallback.onCallback(FileWriterBrowserImpl.this);
		}

		controller.writeFile(result, text, new AsyncCallback<FileWriterDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				if (abort)
					return;
				status = DONE;
				FileErrorException ex;
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					ex = fileErrorException;
				} else {
					ex = new FileErrorException(FileError.INVALID_STATE_ERR);
				}

				FileWriterBrowserImpl.this.error = ex;

				if (onErrorCallback != null) {
					onErrorCallback.onCallback(FileWriterBrowserImpl.this);
				}

				if (onWriteEndCallback != null) {
					onWriteEndCallback.onCallback(FileWriterBrowserImpl.this);
				}
			}

			@Override
			public void onSuccess(FileWriterDTO result) {
				if (abort)
					return;
				status = DONE;
				FileWriterBrowserImpl.this.result = result;

				if (onWriteCallback != null) {
					onWriteCallback.onCallback(FileWriterBrowserImpl.this);
				}

				if (onWriteEndCallback != null) {
					onWriteEndCallback.onCallback(FileWriterBrowserImpl.this);
				}

			}
		});

	}
}
