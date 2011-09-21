package de.kurka.phonegap.client.file.browser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.File;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileReader;
import de.kurka.phonegap.client.file.FileSystem;
import de.kurka.phonegap.client.file.FileTransfer;
import de.kurka.phonegap.client.file.FileTransferError;
import de.kurka.phonegap.client.file.FileUploadCallback;
import de.kurka.phonegap.client.file.FileUploadOptions;
import de.kurka.phonegap.client.file.browser.service.FileRemoteService;
import de.kurka.phonegap.client.file.browser.service.FileRemoteServiceAsync;

public class FileBrowserImpl implements File {

	private FileRemoteServiceAsync service;

	public FileBrowserImpl() {
		service = GWT.create(FileRemoteService.class);
	}

	@Override
	public void requestFileSystem(int fileSystemType, int size, final FileCallback<FileSystem, FileError> callback) {
		service.requestFileSystem(fileSystemType, size, new AsyncCallback<FileSystemBrowserImpl>() {

			@Override
			public void onSuccess(FileSystemBrowserImpl result) {
				callback.onSuccess(result);

			}

			@Override
			public void onFailure(Throwable caught) {
				if (caught instanceof FileErrorException) {
					FileErrorException fileErrorException = (FileErrorException) caught;
					callback.onFailure(fileErrorException);
				} else {
					callback.onFailure(new FileErrorException(FileError.INVALID_STATE_ERR));
				}

			}
		});

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
		// TODO Auto-generated method stub
		return null;
	}

}
