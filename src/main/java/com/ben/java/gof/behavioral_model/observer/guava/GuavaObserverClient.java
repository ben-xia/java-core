package com.ben.java.gof.behavioral_model.observer.guava;

import com.google.common.eventbus.EventBus;

public class GuavaObserverClient {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        GuavaEvent event = new GuavaEvent();
        eventBus.register(event);
        eventBus.post("我是信息");
    }
}
