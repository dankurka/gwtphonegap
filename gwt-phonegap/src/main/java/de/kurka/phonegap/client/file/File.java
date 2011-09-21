package de.kurka.phonegap.client.file;

public interface File {

	public static final int LocalFileSystem_TEMPORARY = 0;
	public static final int LocalFileSystem_PERSISTENT = 1;
	public static final int LocalFileSystem_RESOURCE = 2;
	public static final int LocalFileSystem_APPLICATION = 3;

	public void requestFileSystem(int fileSystemType, int size, FileCallback<FileSystem, FileError> callback);

	public void resolveLocalFileSystemURI(String url, FileCallback<EntryBase, FileError> callback);

	public FileTransfer createFileTransfer();

	public FileReader createReader();
}
