package com.googlecode.gwtphonegap.client.camera;

/**
 * Created by vkiran on 12/17/13.
 */
public class CameraPopoverHandleJsImpl implements CameraPopoverHandle {
    @Override
    public native void setPosition(PopOverOptions popOverOptions) /*-{
        this.setPosition(popOverOptions);
    }-*/;
}
