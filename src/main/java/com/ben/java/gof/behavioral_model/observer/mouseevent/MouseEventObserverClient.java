package com.ben.java.gof.behavioral_model.observer.mouseevent;

import com.ben.java.gof.behavioral_model.observer.mouseevent.handler.Mouse;
import com.ben.java.gof.behavioral_model.observer.mouseevent.handler.MouseEventListener;
import com.ben.java.gof.behavioral_model.observer.mouseevent.handler.MouseEventType;

public class MouseEventObserverClient {

    public static void main(String[] args) {
        MouseEventListener mouseEventListener = new MouseEventListener();
        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, mouseEventListener);
        mouse.click();
    }
}
