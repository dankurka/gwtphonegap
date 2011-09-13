package de.kurka.phonegap.client.file;

public interface FileReader {

	public int getReadyState();

	public String getResult();

	public FileError getError();

	public void setOnLoadStartCallback(ReaderCallback<FileReader> callback);

	public void setOnProgressCallback(ReaderCallback<FileReader> callback);

	public void setOnloadCallback(ReaderCallback<FileReader> callback);

	public void setOnAbortCallback(ReaderCallback<FileReader> callback);

	public void setOnErrorCallback(ReaderCallback<FileReader> callback);

	public void setOnLoadEndCallback(ReaderCallback<FileReader> callback);

	public void abort();

	public void readAsDataUrl(FileEntry entry);

	public void readAsText(FileEntry entry);

}
