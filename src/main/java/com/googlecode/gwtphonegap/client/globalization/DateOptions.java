package com.googlecode.gwtphonegap.client.globalization;

public class DateOptions {
  public static final String LENGTH_SHORT = "short";
  public static final String LENGTH_MEDIUM = "medium";
  public static final String LENGTH_LONG = "long";
  public static final String LENGTH_FULL = "long";

  public static final String SELECTOR_DATE = "date";
  public static final String SELECTOR_TIME = "time";
  public static final String SELECTOR_DATE_AND_TIME = "date and time";

  private String formatLength;
  private String selector;

  public DateOptions() {

  }

  public DateOptions(String formatLength, String selector) {
    this.formatLength = formatLength;
    this.selector = selector;
  }

  public String getFormatLength() {
    return formatLength;
  }

  public String getSelector() {
    return selector;
  }

  public void setFormatLength(String formatLength) {
    this.formatLength = formatLength;
  }

  public void setSelector(String selector) {
    this.selector = selector;
  }
}
