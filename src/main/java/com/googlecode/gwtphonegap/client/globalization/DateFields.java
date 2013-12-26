package com.googlecode.gwtphonegap.client.globalization;

/**
 * Created by vkiran on 12/4/13.
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
