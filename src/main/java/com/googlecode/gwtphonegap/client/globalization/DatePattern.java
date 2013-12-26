/*
 * Copyright 2012 Daniel Kurka
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

public interface DatePattern {
    /**
     * The date and time pattern to format and parse dates. The patterns follow Unicode Technical Standard #35. (String)
     * @return
     */
  public String getPattern();

    /**
     * The abbreviated name of the time zone on the client. (String)
     * @return
     */
    public String getTimeZone();

    /**
     * The current difference in seconds between the client's time zone and coordinated universal time. (Number)
     * @return
     */
    public int getUtc_offset();

    /**
     *  The current daylight saving time offset in seconds between the client's non-daylight saving's time zone
     *  and the client's daylight saving's time zone. (Number)
     * @return
     */
    public int getDst_offset();
}
