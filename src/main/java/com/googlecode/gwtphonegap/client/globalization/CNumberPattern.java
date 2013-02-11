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

public interface CNumberPattern {
  /**
   * The number pattern for formatting and parsing numbers. The patterns follow Unicode Technical
   * Standard #35. http://unicode.org/reports/tr35/tr35-4.html
   * 
   * @return
   */
  public String getPattern();

  /**
   * The symbol to be used when formatting and parsing e.g., percent or currency symbol.
   * 
   * @return
   */
  public String getSymbol();

  /**
   * The number of fractional digits to use when parsing and formatting numbers.
   * 
   * @return
   */
  public int getFraction();

  /**
   * The rounding increment to use when parsing and formatting.
   * 
   * @return
   */
  public double getRounding();

  /**
   * The symbol to use for positive numbers when parsing and formatting.
   * 
   * @return
   */
  public String getPositive();

  /**
   * The symbol to use for negative numbers when parsing and formatting.
   * 
   * @return
   */
  public String getNegative();

  /**
   * The decimal symbol to use for parsing and formatting.
   * 
   * @return
   */
  public String getDecimal();

  /**
   * The grouping symbol to use for parsing and formatting.
   * 
   * @return
   */
  public String getGrouping();
}
