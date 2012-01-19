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

public interface FileReader {

	public static final int EMPTY = 0;
	public static final int LOADING = 1;
	public static final int DONE = 2;

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
