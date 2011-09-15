package de.kurka.phonegap.client.file;

public interface FileUploadResult {
	public long getBytesSent();

	public long getResponseCode();

	public String getResponse();
}
