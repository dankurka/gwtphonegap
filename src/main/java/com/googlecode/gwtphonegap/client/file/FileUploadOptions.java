/*
 * Copyright 2011 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.file;

import java.util.Map;

/**
 * A FileUploadOptions object can be passed to the FileTransfer object's upload() method to
 * specify additional parameters to the upload script.
 */
public class FileUploadOptions {

    /**
     * The name of the form element. Defaults to file. (DOMString)
     */
  private String fileKey;

    /**
     * The file name to use when saving the file on the server. Defaults to image.jpg. (DOMString)
     */
  private String fileName;

    /**
     * The mime type of the data to upload. Defaults to image/jpeg. (DOMString)
     */
  private String mimeType;

    /**
     *  A set of optional key/value pairs to pass in the HTTP request. (Object)
     */
  private Map<String, String> params;

    /**
     *  A map of header name/header values. Use an array to specify more than one value. (Object)
     */
  private Map<String, String> headers;

    /**
     * Whether to upload the data in chunked streaming mode. Defaults to true. (Boolean)
     */
    private boolean chunkedMode = true;

  public FileUploadOptions() {

  }

  public FileUploadOptions(String fileKey, String fileName, String mimeType,
      Map<String, String> params) {
    this(fileKey, fileName, mimeType, params, null);
  }

  public FileUploadOptions(String fileKey, String fileName, String mimeType,
      Map<String, String> params, Map<String, String> headers) {
      this(fileKey, fileName, mimeType, params, headers,true);
  }

    public FileUploadOptions(String fileKey, String fileName, String mimeType,
                             Map<String, String> params, Map<String, String> headers,boolean chunkedMode) {
        this.fileKey = fileKey;
        this.fileName = fileName;
        this.mimeType = mimeType;
        this.params = params;
        this.headers = headers;
        this.chunkedMode = chunkedMode;
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

  public void setHeaders(Map<String, String> headers) {
    this.headers = headers;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

    /**
     * Whether to upload the data in chunked streaming mode. Defaults to true. (Boolean)
     */
    public boolean isChunkedMode() {
        return chunkedMode;
    }

    public void setChunkedMode(boolean chunkedMode) {
        this.chunkedMode = chunkedMode;
    }
}
