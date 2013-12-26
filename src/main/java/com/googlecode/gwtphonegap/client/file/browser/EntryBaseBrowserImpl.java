package com.googlecode.gwtphonegap.client.file.browser;

import com.googlecode.gwtphonegap.client.file.DirectoryEntry;
import com.googlecode.gwtphonegap.client.file.EntryBase;
import com.googlecode.gwtphonegap.client.file.FileEntry;

/**
 * Created by vkiran on 12/23/13.
 */
public class EntryBaseBrowserImpl implements EntryBase {
    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public FileEntry getAsFileEntry() {
        return null;
    }

    @Override
    public DirectoryEntry getAsDirectoryEntry() {
        return null;
    }
}
