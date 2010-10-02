package de.kurka.phonegap.client.file;

public interface FileExistsCallback {
	public void onFileExist();

	public void onFileNotExist();

	public void onFailure();
}
