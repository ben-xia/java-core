package com.ben.java.gof.behavioral_model.observer.mouseevent.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象的被观察者(主题/目标对象)
 */
public abstract class EventContext {
    private Map<String, Event> eventMap = new HashMap<>();

    public void addListener(String eventType, EventListener target, Method callback) {
        eventMap.put(eventType, new Event(target, callback));
    }

    public void addListener(String eventType, EventListener target) {
        try {
            this.addListener(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (NoSuchMethodException e) {
            return;
        }
    }

    private String toUpperFirstCase(String eventType) {
        char[] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    public void trigger(Event event) {

        try {
            event.setSource(this);
            event.setTime(System.currentTimeMillis());
            EventListener target = event.getTarget();
            Method callback = event.getCallback();
            callback.invoke(target, event);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public void trigger(String eventType) {
        if (!this.eventMap.containsKey(eventType)) {
            return;
        }

        trigger(eventMap.get(eventType).setTrigger(eventType));

    }
}


















