package de.kurka.phonegap.client.file;

import java.util.Map;

public class FileUploadOptions {
	private String fileKey;

	private String fileName;

	private String mimeType;

	private Map<String, String> params;

	public FileUploadOptions() {

	}

	public FileUploadOptions(String fileKey, String fileName, String mimeType, Map<String, String> params) {
		this.fileKey = fileKey;
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.params = params;
	}

	public String getFileKey() {
		return fileKey;
	}

	public void setFileKey(String fileKey) {
		this.fileKey = fileKey;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

}
