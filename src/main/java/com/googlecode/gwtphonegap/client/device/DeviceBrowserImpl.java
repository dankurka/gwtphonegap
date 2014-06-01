/*
 * Copyright 2010 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.gwtphonegap.client.device;

import com.google.gwt.user.client.Cookies;

import java.util.Date;

public class DeviceBrowserImpl implements Device {

  @Override
  public String getName() {
    return "";
  }

  @Override
  public String getPhoneGapVersion() {
    return "none";
  }

  @Override
  public String getPlatform() {
    return "browser";
  }

  @Override
  public String getUuid() {
    String value = Cookies.getCookie("gwt-phonegap-uuid");
    if (value == null) {
      long end = System.currentTimeMillis() + 60l * 60l * 24l * 356l * 1000l;
      value = getPseudoGUUID();
      Cookies.setCookie("gwt-phonegap-uuid", value, new Date(end));

    }
    return value;
  }

  private static final char[] CHAR_ARRAY =
      "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

  public static String getPseudoGUUID() {
    char[] buffer = new char[36];

    for (int i = 0; i < 36; i++) {

      int random = (int) (Math.random() * 16);
      int index = 0;
      if (i == 19) {
        index = (random & 0x3) | 0x8;
      } else {
        index = random & 0xf;
      }
      buffer[i] = CHAR_ARRAY[index];

    }

    buffer[8] = buffer[13] = buffer[18] = buffer[23] = '-';
    buffer[14] = '4';

    return new String(buffer);
  }

  @Override
  public String getVersion() {
    return "none";
  }

  @Override
  public String getModel() {
    return "";
  }

  @Override
  public boolean isAvailable() {
    return true;
  }
}
