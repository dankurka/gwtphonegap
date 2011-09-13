package de.kurka.phonegap.client.file.browser;

import de.kurka.phonegap.client.file.EntryBase;
import de.kurka.phonegap.client.file.File;
import de.kurka.phonegap.client.file.FileCallback;
import de.kurka.phonegap.client.file.FileError;
import de.kurka.phonegap.client.file.FileSystem;

public class FileBrowserImpl implements File {

	@Override
	public void requestFileSystem(int fileSystemType, int size, FileCallback<FileSystem, FileError> callback) {
		callback.onFailure(new FileErrorBrowserImpl(FileError.NOT_FOUND_ERR));

	}

	@Override
	public void resolveLocalFileSystemURI(String url, FileCallback<EntryBase, FileError> callback) {
		callback.onFailure(new FileErrorBrowserImpl(FileError.NOT_FOUND_ERR));

	}

}
