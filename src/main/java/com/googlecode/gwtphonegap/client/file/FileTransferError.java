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
 * The FileTransferError object is passed to the error callback when an error occurs when uploading or downloading a file.
 */
public interface FileTransferError {
	public static final int FILE_NOT_FOUND_ERR = 1;
	public static final int INVALID_URL_ERR = 2;
	public static final int CONNECTION_ERR = 3;
    public static final int ABORT_ERR = 4;

    /**
     *  One of the predefined error codes listed. (Number)
     * @return
     */
	public int getCode();

    /**
     * URI to the source. (String)
     * @return
     */
    public String getSource();

    /**
     *  URI to the target. (String)
     * @return
     */
    public String getTarget();

    /**
     * HTTP status code. This attribute is only available when a response code is received from the HTTP connection. (Number)
     * @return
     */
    public int getHttp_Status();
}
