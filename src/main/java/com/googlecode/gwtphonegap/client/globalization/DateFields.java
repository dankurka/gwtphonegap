/*
 * Copyright 2014 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.globalization;

/**
 * @author vkiran
 */
public interface DateFields {

    /**
     * The four digit year. (Number)
     * @return
     */
    public int getYear();

    /**
     * The month from (0-11). (Number)
     * @return
     */
    public int getMonth();

    /**
     * The day from (1-31). (Number)
     * @return
     */
    public int getDay() ;

    /**
     * The hour from (0-23). (Number)
     * @return
     */
    public int getHour();

    /**
     * The minute from (0-59). (Number)
     * @return
     */
    public int getMinute();

    /**
     * The second from (0-59). (Number)
     * @return
     */
    public int getSecond();

    /**
     *  The milliseconds (from 0-999), not available on all platforms. (Number)
     * @return
     */
    public Long getMillisecond();
}
