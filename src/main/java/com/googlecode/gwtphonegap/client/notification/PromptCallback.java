package com.googlecode.gwtphonegap.client.notification;

/**
 * Created by vkiran on 10/12/13.
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
