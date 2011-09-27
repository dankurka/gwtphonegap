package com.googlecode.gwtphonegap.client.file;

public interface FileUploadCallback {
	public void onSuccess(FileUploadResult result);

	public void onFailure(FileTransferError error);
}
