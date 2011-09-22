package de.kurka.phonegap.client.file;

public interface FileSystem {
	public static final int LocalFileSystem_PERSISTENT = 0;

	public static final int LocalFileSystem_TEMPORARY = 1;

	public static final int LocalFileSystem_RESOURCE = 2;
	public static final int LocalFileSystem_APPLICATION = 3;

	public String getName();

	public DirectoryEntry getRoot();
}
