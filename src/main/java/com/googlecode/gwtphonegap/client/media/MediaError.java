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
package com.googlecode.gwtphonegap.client.media;

public interface MediaError {

    public static final int MEDIA_ERR_NONE_ACTIVE = 0;
    public static final int MEDIA_ERR_ABORTED = 1;
    public static final int MEDIA_ERR_NETWORK = 2;
    public static final int MEDIA_ERR_DECODE = 3;
    public static final int MEDIA_ERR_NONE_SUPPORTED = 4;
    public static final int MEDIA_ERR_SRC_NOT_SUPPORTED = 4;

    public int getErrorCode();

    public String getErrorMessage();

}
