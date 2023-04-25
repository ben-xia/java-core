package com.ben.java.gof.behavioral_model.observer.mouseevent.core;

import java.lang.reflect.Method;

public class Event {
    //事件源,动作是由谁触发
    private Object source;

    //事件触发要通知的对象(观察者)
    private  EventListener target;

    //观察者的回调函数
    private Method callback;

    //事件名称
    private String trigger;

    //事件触发时间
    private long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public void setTarget(EventListener target) {
        this.target = target;
    }

    public Event setCallback(Method callback) {
        this.callback = callback;
        return this;
    }

    public Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Object getSource() {
        return source;
    }

    public EventListener getTarget() {
        return target;
    }

    public Method getCallback() {
        return callback;
    }

    public String getTrigger() {
        return trigger;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", trigger='" + trigger + '\'' +
                ", time=" + time +
                '}';
    }
}
