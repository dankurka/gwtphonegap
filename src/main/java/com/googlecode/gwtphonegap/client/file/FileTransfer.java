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

import java.util.Map;

/**
 * The FileTransfer object provides a way to upload files to a remote server using an HTTP multi-part POST request.
 * Both HTTP and HTTPS protocols are supported. Optional parameters can be specified by passing a FileUploadOptions
 * object to the upload() method. On successful upload, a FileUploadResult object is passed to the success callback.
 * If an error occurs, a FileTransferError object is passed to the error callback.
 * It is also possible (only on iOS and Android) to download a file from a remote server and save it on the device.
 */
public interface FileTransfer {
    /**
     * fileUri: Full path of the file on the device.]
     * serverUrl: URL of the server to receive the file, as encoded by encodeURI().
     *  trustAllHosts: Optional parameter, defaults to false.
     *  If set to true, it accepts all security certificates.
     *  This is useful since Android rejects self-signed security certificates.
     *  Not recommended for production use. Supported on Android and iOS. (boolean)
     *  options: Optional parameters such as file name and mimetype.
     *  callback: Callback to handle the success and failure of the file upload.
     *  Android Quirks: Set the chunkedMode option to false to prevent problems uploading to a Nginx server.
     * @param fileUri
     * @param serverUrl
     * @param trustAllHosts
     * @param options
     * @param callback
     */
	public void upload(String fileUri, String serverUrl, boolean trustAllHosts,FileUploadOptions options, FileUploadCallback callback);


	public void download(String sourceUrl, String filePath, boolean trustAllHosts, Map<String, String> options,FileDownloadCallback callback);

    /**
     * Aborts an in-progress transfer.
     * The onerror callback is passed a FileTransferError object which has an error code of
     * FileTransferError.ABORT_ERR.
     */
	public void abort();
}
