package de.kurka.phonegap.client.file.browser;

import de.kurka.gwt.collection.shared.LightArray;
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
import de.kurka.phonegap.client.file.browser.service.FileSystemController;

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

}
