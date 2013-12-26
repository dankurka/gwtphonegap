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

/**
 * The FileReader object offers a way to read files from the device's file system.
 * Files can be read as text or as a base64 data-encoded string.
 * Event listeners receive the loadstart, progress, load, loadend, error, and abort events.
 */
public interface FileReader {

	public static final int EMPTY = 0;
	public static final int LOADING = 1;
	public static final int DONE = 2;

    /**
     * One of the reader's three possible states, either EMPTY, LOADING or DONE.
     * @return
     */
	public int getReadyState();

    /**
     * The contents of the file that have been read. (DOMString)
     * @return
     */
	public String getResult();

    /**
     * An object containing errors. (FileError)
     * @return
     */
	public FileError getError();

    /**
     * Called when the read starts. (Function)
     * @param callback
     */
	public void setOnLoadStartCallback(ReaderCallback<FileReader> callback);

    /**
     * Called while reading the file, reporting progress in terms of progress.
     * loaded/progress.total. (Function)
     * @param callback
     */
	public void setOnProgressCallback(ReaderCallback<FileReader> callback);

    /**
     * Called when the read has successfully completed. (Function)
     * @param callback
     */
	public void setOnLoadCallback(ReaderCallback<FileReader> callback);

    /**
     * Called when the read has been aborted.
     * For instance, by invoking the abort() method. (Function)
     * @param callback
     */
	public void setOnAbortCallback(ReaderCallback<FileReader> callback);

    /**
     * Called when the read has failed. (Function)
     * @param callback
     */
	public void setOnErrorCallback(ReaderCallback<FileReader> callback);

    /**
     * Called when the request has completed (either in success or failure). (Function)
     * @param callback
     */
	public void setOnLoadEndCallback(ReaderCallback<FileReader> callback);

    /**
     * Aborts reading file.
     */
	public void abort();

    /**
     * Read file and return data as a base64-encoded data URL.
     * @param entry
     */
	public void readAsDataUrl(FileEntry entry);

    /**
     * Reads text file.
     * @param entry
     */
	public void readAsText(FileEntry entry,String encoding);

    /**
     * Reads file as binary and returns a binary string.
     * @param entry
     */
    public void readAsBinaryString(FileEntry entry);

    /**
     * Reads file as an ArrayBuffer.
     * @param entry
     */
    public void readAsArrayBuffer(FileEntry entry);
}
