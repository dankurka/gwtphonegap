package de.kurka.phonegap.client.file;

public interface FileTransferError {
	public static final int FILE_NOT_FOUND_ERR = 1;
	public static final int INVALID_URL_ERR = 2;
	public static final int CONNECTION_ERR = 3;

	public int getCode();
}
