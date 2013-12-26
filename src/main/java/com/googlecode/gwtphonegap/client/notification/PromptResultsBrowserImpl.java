package com.googlecode.gwtphonegap.client.notification;

/**
 * Created by vkiran on 10/12/13.
 */
public class PromptResultsBrowserImpl implements PromptResults {

    private int buttonIndex;
    private String inputMessage;
    public PromptResultsBrowserImpl(int buttonIndex, String inputMessage){
    this.buttonIndex = buttonIndex;
        this.inputMessage = inputMessage;
    }
    @Override
    public int getButtonIndex() {
        return buttonIndex;
    }

    @Override
    public String getInput1() {
        return inputMessage;
    }
}
