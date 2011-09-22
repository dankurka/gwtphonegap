package de.kurka.phonegap.client.file;

public interface FileWriter {
	public static final int INIT = 0;
	public static final int WRITING = 1;
	public static final int DONE = 2;

	public int getReadyState();

	public String getFileName();

	public long getLength();

	public long getPosition();

	public FileError getError();

	public void setOnWriteStartCallback(WriterCallback<FileWriter> callback);

	public void setOnProgressCallback(WriterCallback<FileWriter> callback);

	public void setOnWriteCallback(WriterCallback<FileWriter> callback);

	public void setOnAbortCallback(WriterCallback<FileWriter> callback);

	public void setOnErrorCallback(WriterCallback<FileWriter> callback);

	public void setOnWriteEndCallback(WriterCallback<FileWriter> callback);

	public void abort();

	public void seek(long position);

	public void truncate(long position);

	public void write(String text);
}
