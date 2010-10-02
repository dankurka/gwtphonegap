package de.kurka.phonegap.client.file;

public interface FileReadCallback {
	public void onSuccess(String content);

	public void onFailure();
}
