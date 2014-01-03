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
public interface CurrencyPattern {

    /**
     * The currency pattern to format and parse currency values.
     * The patterns follow Unicode Technical Standard #35. (String)
     * @return
     */
    public String getPattern();

    /**
     * The ISO 4217 currency code for the pattern. (String)
     * @return
     */
    public String getCode();

    /**
     *The decimal symbol to use for parsing and formatting. (String)
     * @return
     */
    public String getDecimal();

    /**
     *The grouping symbol to use for parsing and formatting. (String)
     * @return
     */
    public String getGrouping();

    /**
     *The rounding increment to use when parsing and formatting. (Number)
     * @return
     */
    public int getRounding();

    /**
     * The number of fractional digits to use when parsing and formatting currency. (Number)
     * @return
     */
    public double getFraction();

}
