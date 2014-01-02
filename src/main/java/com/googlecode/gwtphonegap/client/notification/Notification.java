/*
 * Copyright 2010 Daniel Kurka
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
package com.googlecode.gwtphonegap.client.notification;

/**
 * 
 * @see {@link http://docs.phonegap.com/phonegap_notification_notification.md.html}
 * 
 * @author Daniel Kurka
 *
 */
public interface Notification {

	public void alert(String message);

	public void alert(String message, AlertCallback callback);

	public void alert(String message, AlertCallback callback, String title);

	public void alert(String message, AlertCallback callback, String title, String buttonName);

	public void confirm(String message, ConfirmCallback callback);

	public void confirm(String message, ConfirmCallback callback, String title);

	public void confirm(String message, ConfirmCallback callback, String title, String[] buttonLabels);

	public void beep(int count);

	public void vibrate(int milliseconds);

        public void prompt(String message, PromptCallback callback);

        public void prompt(String message, PromptCallback callback, String title);

        public void prompt(String message, PromptCallback callback, String title, String defaultText);

         /**
         * Shows a customizable prompt dialog box.
         * The notification.prompt method displays a native dialog box that is more customizable than the browser's prompt function.
         * @param message
         * @param callback
         * @param title
         * @param defaultText
         * @param buttonLabels
         */
         public void prompt(String message, PromptCallback callback, String title, String defaultText, String[] buttonLabels);


}