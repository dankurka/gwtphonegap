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
 * object that allows you to create and write data to a file.
 * The FileWriter object offers a way to write UTF-8 encoded files to the device file system.
 * Applications respond to writestart, progress, write, writeend, error, and abort events.
 *  Each FileWriter corresponds to a single file, to which data can be written many times.
 *  The FileWriter maintains the file's position and length attributes, which allow the app to
 *  seek and write anywhere in the file. By default, the FileWriter writes to the beginning of the file,
 *  overwriting existing data.
 *  Set the optional append boolean to true in the FileWriter's constructor to write to the end of the file.
 */
public interface FileWriter {
	public static final int INIT = 0;
	public static final int WRITING = 1;
	public static final int DONE = 2;

    /**
     * One of the three possible states, either INIT, WRITING, or DONE.
     * @return
     */
	public int getReadyState();

    /**
     * The name of the file to be written. (DOMString)
     * @return
     */
	public String getFileName();

    /**
     * The length of the file to be written. (long)
     * @return
     */
	public long getLength();

    /**
     * The current position of the file pointer. (long)
     * @return
     */
	public long getPosition();

    /**
     *  An object containing errors. (FileError)
     * @return
     */
	public FileError getError();

    /**
     *Called when the write starts. (Function)
     * @param callback
     */
	public void setOnWriteStartCallback(WriterCallback<FileWriter> callback);

    /**
     * Called while writing the file, reporting progress in terms of progress.loaded/progress.total. (Function)
     * This property is not supported.
     * @param callback
     */
	public void setOnProgressCallback(WriterCallback<FileWriter> callback);

    /**
     *  Called when the request has completed successfully. (Function)
     * @param callback
     */
	public void setOnWriteCallback(WriterCallback<FileWriter> callback);

    /**
     * Called when the write has been aborted. For instance, by invoking the abort() method. (Function)
     * @param callback
     */
	public void setOnAbortCallback(WriterCallback<FileWriter> callback);

    /**
     *Called when the write has failed. (Function)
     * @param callback
     */
	public void setOnErrorCallback(WriterCallback<FileWriter> callback);

    /**
     *Called when the request has completed (either in success or failure). (Function)
     * @param callback
     */
	public void setOnWriteEndCallback(WriterCallback<FileWriter> callback);

    /**
     * Aborts writing the file.
     */
	public void abort();

    /**
     * Moves the file pointer to the specified byte.
     * @param position
     */
	public void seek(long position);

    /**
     * Shortens the file to the specified length.
     * @param position
     */
	public void truncate(long position);

    /**
     *  Writes data to the file.
     * @param text
     */
	public void write(String text);
}
