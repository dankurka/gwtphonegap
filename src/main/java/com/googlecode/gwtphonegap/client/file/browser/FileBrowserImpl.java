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
package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.File;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileDownloadCallback;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.FileSystem;
import com.googlecode.gwtphonegap.client.file.FileTransfer;
import com.googlecode.gwtphonegap.client.file.FileTransferError;
import com.googlecode.gwtphonegap.client.file.FileUploadCallback;
import com.googlecode.gwtphonegap.client.file.FileUploadOptions;
import com.googlecode.gwtphonegap.client.file.browser.service.FileSystemController;
import com.googlecode.gwtphonegap.collection.shared.LightArray;

import java.util.Map;

/**
 * Experimental
 * 
 * this is an implementation of the phonegap file API which can be run with GWT
 * hosted mode It simulates the api by using a remote service
 * 
 * @author Daniel Kurka
 * 
 */
public class FileBrowserImpl implements File {

	private final FileSystemController fileController;

	public FileBrowserImpl() {
		fileController = new FileSystemController();

	}

	public void readDirectory(String fullPath, FileCallback<LightArray<EntryBase>, FileError> callback) {

		fileController.readDirectory(fullPath, callback);

	}

	@Override
	public void requestFileSystem(int fileSystemType, int size, final FileCallback<FileSystem, FileError> callback) {
		fileController.requestFileSystem(fileSystemType, size, callback);

	}

	@Override
	public void resolveLocalFileSystemURI(String url, FileCallback<EntryBase, FileError> callback) {
		callback.onFailure(new FileErrorBrowserImpl(FileError.NOT_FOUND_ERR));

	}

	@Override
	public FileTransfer createFileTransfer() {
		return new FileTransfer() {

			@Override
			public void upload(String fileUri, String serverUrl, boolean trustAllHosts,FileUploadOptions options, FileUploadCallback callback) {
				FileTransferError fileTransferError = new FileTransferError() {

					@Override
					public int getCode() {
						return FileTransferError.FILE_NOT_FOUND_ERR;
					}

                    @Override
                    public String getSource() {
                        return null;
                    }

                    @Override
                    public String getTarget() {
                        return null;
                    }

                    @Override
                    public int getHttp_Status() {
                        return 0;
                    }
                };

				callback.onFailure(fileTransferError);

			}

			@Override
			public void download(String sourceUrl, String filePath, boolean trustAllHosts, Map<String, String> options,FileDownloadCallback callback) {
				FileTransferError fileTransferError = new FileTransferError() {

					@Override
					public int getCode() {
						return FileTransferError.FILE_NOT_FOUND_ERR;
					}

                    @Override
                    public String getSource() {
                        return null;
                    }

                    @Override
                    public String getTarget() {
                        return null;
                    }

                    @Override
                    public int getHttp_Status() {
                        return 0;
                    }
                };

				callback.onFailure(fileTransferError);

			}

			@Override
			public void abort() {

			}
		};
	}

	@Override
	public FileReader createReader() {
		return new FileReaderBrowserImpl(fileController);
	}

	@Override
	public void setBasePath(String path) {
		fileController.setBasePath(path);

	}

}
