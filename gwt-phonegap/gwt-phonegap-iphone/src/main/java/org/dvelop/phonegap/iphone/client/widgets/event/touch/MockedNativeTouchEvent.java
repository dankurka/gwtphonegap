package org.dvelop.phonegap.iphone.client.widgets.event.touch;

import com.google.gwt.dom.client.NativeEvent;

/**
 * User: daniel kurka
 * Date: 20.05.2010
 * Time: 23:46:15
 */
public class MockedNativeTouchEvent extends NativeTouchEvent {

    private NativeEvent nativeEvent;

    public MockedNativeTouchEvent(NativeEvent nativeEvent) {
        this.nativeEvent = nativeEvent;
    }

    @Override
    public void preventDefault() {
        this.nativeEvent.preventDefault();
    }


    @Override
    public int getTouchCount() {
        return 1;
    }

    @Override
    public int getTargetTouchCount() {
        return 1;
    }

    @Override
    public int getChangedTouchCount() {
        return 1;
    }

    @Override
    public NativeEvent getTouch(int index) {
        return nativeEvent;
    }

    @Override
    public NativeEvent getTargetTouch(int index) {
        return nativeEvent;
    }

    @Override
    public NativeEvent getChangedTouch(int index) {
        return nativeEvent;
    }
}
