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
package com.googlecode.gwtphonegap.client.notification;

/**
 * @author vkiran
 */
public interface PromptCallback {

    /**
     * The promptCallback executes when the user presses one of the buttons in the prompt dialog box. The results object passed to the callback contains the following properties:
     * buttonIndex: The index of the pressed button. (Number) Note that the index uses one-based indexing, so the value is 1, 2, 3, etc.
     * input1: The text entered in the prompt dialog box. (String)
     * Supported Platforms : Android & iOS
     *
     * @param results
     */
    public void onPrompt(PromptResults results);
}
