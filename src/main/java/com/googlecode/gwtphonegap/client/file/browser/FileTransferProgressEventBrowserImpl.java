package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.FileTransferProgressEvent;

/**
 * Created by vkiran on 12/23/13.
 */
public class FileTransferProgressEventBrowserImpl implements FileTransferProgressEvent {
    @Override
    public boolean isLengthComputable() {
        return false;
    }

    @Override
    public long getLoadedBytes() {
        return 0;
    }

    @Override
    public long getTotalBytes() {
        return 0;
    }
}
