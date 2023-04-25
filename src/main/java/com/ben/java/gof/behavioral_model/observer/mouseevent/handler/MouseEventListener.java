package com.ben.java.gof.behavioral_model.observer.mouseevent.handler;

import com.ben.java.gof.behavioral_model.observer.mouseevent.core.Event;
import com.ben.java.gof.behavioral_model.observer.mouseevent.core.EventListener;

public class MouseEventListener implements EventListener {
    @Override
    public void onClick(Event event){
        System.out.println("触发点击事件,事件详情");
    }
}
