package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.File;
import com.googlecode.gwtphonegap.client.file.FileCallback;
import com.googlecode.gwtphonegap.client.file.FileError;
import com.googlecode.gwtphonegap.client.file.FileReader;
import com.googlecode.gwtphonegap.client.file.FileSystem;
import com.googlecode.gwtphonegap.client.file.FileTransfer;
import com.googlecode.gwtphonegap.client.file.FileTransferError;
import com.googlecode.gwtphonegap.client.file.FileUploadCallback;
import com.googlecode.gwtphonegap.client.file.FileUploadOptions;
import com.googlecode.gwtphonegap.client.file.browser.service.FileSystemController;

import de.kurka.gwt.collection.shared.LightArray;

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

	private FileSystemController fileController;

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
			public void upload(String fileUri, String serverUrl, FileUploadOptions options, FileUploadCallback callback) {
				FileTransferError fileTransferError = new FileTransferError() {

					@Override
					public int getCode() {
						return FileTransferError.FILE_NOT_FOUND_ERR;
					}
				};

				callback.onFailure(fileTransferError);

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
