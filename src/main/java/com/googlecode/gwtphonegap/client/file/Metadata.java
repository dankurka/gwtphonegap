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
 * An interface that supplies information about the state of a file or directory.
 * The Metadata object represents information about the state of a file or directory.
 * Calling a DirectoryEntry or FileEntry object's getMetadata() method results in a Metadata instance.
 */
public interface Metadata {

    /**
     * The time when the file or directory was last modified. (Date)
     * @return
     */
	public Date getModificationTime();
}
