package com.googlecode.gwtphonegap.client.file;

import com.googlecode.gwtphonegap.collection.shared.LightArray;

/**
 * This object provides a way to obtain root file systems.
 * Created by vkiran on 12/17/13.
 */
public interface LocalFileSystem {

    /**
     * Used for storage that should not be removed by the user agent without application or user permission.
     */
    public static final int PERSISTENT = 1;
    /**
     * Used for storage with no guarantee of persistence.
     */
    public static final int TEMPORARY = 0;

    /**
     * Request a file system in which to store application data.
     * @param type local file system type, see LocalFileSystem Constants
     * @param fileSize  indicates how much storage space, in bytes, the application expects to need
     * @param callback invoked with a FileSystem object if success or  invoked if error occurs retrieving file system
     */
    public void requestFileSystem(int type,long fileSize, FileCallback<FileSystem, FileError> callback);

    /**
     *  Look up file system Entry referred to by local URI.
     * @param uri  URI referring to a local file or directory
     * @param callback invoked with Entry object corresponding to URI if success else   invoked if error occurs retrieving file system entry
     */
    public void resolveLocalFileSystemURI(String uri, FileCallback<EntryBase, FileError> callback);
}
