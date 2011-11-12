package com.googlecode.gwtphonegap.client.file;

public interface FileTransfer {
	public void upload(String fileUri, String serverUrl, FileUploadOptions options, FileUploadCallback callback);
}
