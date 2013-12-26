package com.googlecode.gwtphonegap.client.globalization;

/**
 * Created by vkiran on 12/17/13.
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
