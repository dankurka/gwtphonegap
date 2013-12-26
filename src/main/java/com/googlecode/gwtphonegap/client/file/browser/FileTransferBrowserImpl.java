package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.FileDownloadCallback;
import com.googlecode.gwtphonegap.client.file.FileTransfer;
import com.googlecode.gwtphonegap.client.file.FileUploadCallback;
import com.googlecode.gwtphonegap.client.file.FileUploadOptions;

import java.util.Map;

/**
 * Created by vkiran on 12/23/13.
 */
public class FileTransferBrowserImpl implements FileTransfer {
    @Override
    public void upload(String fileUri, String serverUrl, boolean trustAllHosts, FileUploadOptions options, FileUploadCallback callback) {

    }

    @Override
    public void download(String sourceUrl, String filePath, boolean trustAllHosts, Map<String, String> options, FileDownloadCallback callback) {

    }

    @Override
    public void abort() {

    }
}
