package de.kurka.phonegap.client.file.browser;

import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.File;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileSystem;
import de.kurka.phonegap.client.file.FileTransfer;
import de.kurka.phonegap.client.file.FileTransferError;
import de.kurka.phonegap.client.file.FileUploadCallback;
import de.kurka.phonegap.client.file.FileUploadOptions;

public class FileBrowserImpl implements File {

	@Override
	public void requestFileSystem(int fileSystemType, int size, FileCallback<FileSystem, FileError> callback) {
		callback.onFailure(new FileErrorBrowserImpl(FileError.NOT_FOUND_ERR));

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

}
