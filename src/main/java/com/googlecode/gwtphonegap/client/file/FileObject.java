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

import java.util.Date;

/**
 * The File object contains attributes of a single file.
 * You can get an instance of a File object by calling a FileEntry object's file() method.
 */
public interface FileObject {

    /**
     * The name of the file. (DOMString)
     * @return
     */
	public String getName();

    /**
     *  The full path of the file including the file name. (DOMString)
     * @return
     */
	public String getFullPath();

    /**
     *  The mime type of the file. (DOMString)
     * @return
     */
	public String getType();

    /**
     *  The last time the file was modified. (Date)
     * @return
     */
	public Date getLastModifiedDate();

    /**
     * The size of the file in bytes. (long)
     * @return
     */
	public Long size();

    /**
     * Return a new File object, for which FileReader returns only the specified portion of the file.
     * Negative values for start or end are measured from the end of the file.
     * Indexes are positioned relative to the current slice.
     * @param start
     * @param end
     * @return
     */
    public FileObject slice(Long start, Long end);
}
