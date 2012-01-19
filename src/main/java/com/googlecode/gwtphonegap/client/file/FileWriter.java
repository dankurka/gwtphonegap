/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.file;

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
