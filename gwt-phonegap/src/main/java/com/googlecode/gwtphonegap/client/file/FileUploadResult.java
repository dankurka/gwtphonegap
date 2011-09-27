package com.googlecode.gwtphonegap.client.file;

public interface FileUploadResult {
	public long getBytesSent();

	public long getResponseCode();

	public String getResponse();
}
