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
package com.googlecode.gwtphonegap.client.capture;

import java.util.Date;

/**
 * Encapsulates properties of a media capture file.
 * @author Daniel Kurka
 */
public interface MediaFile {
    
        /**
         * The name of the file, without path information.
         * @return 
         */
	public String getName();

        /**
         * The full path of the file, including the name. 
         * @return 
         */
	public String getFullPath();

        /**
         * The file's mime type 
         * @return 
         */
	public String getType();

        /**
         * The date and time when the file was last modified. 
         * @return 
         */
	public Date getLastModifiedDate();

        /**
         *  The size of the file, in bytes.
         * @return 
         */
	public long getSize();

        /**
         * Retrieves the format information of the media file.
         * @param callback 
         */
	public void getFormatData(MediaFormatDataCallback callback);
}
