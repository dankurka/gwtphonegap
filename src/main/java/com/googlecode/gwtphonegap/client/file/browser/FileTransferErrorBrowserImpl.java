package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.FileTransferError;

/**
 * Created by vkiran on 12/23/13.
 */
public class FileTransferErrorBrowserImpl implements FileTransferError {
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getSource() {
        return null;
    }

    @Override
    public String getTarget() {
        return null;
    }

    @Override
    public int getHttp_Status() {
        return 0;
    }
}
