package com.ben.java.gof.behavioral_model.observer.listener;

/**
 * @author ben-xia
 * @desc   事件源：事件发生的地点
 * @date 2019/5/19
 */
public class EventSource02 implements IEvent {
    private IEventListener ml;
    boolean button;
    boolean mouse;

    @Override
    public void setEventListener(IEventListener arg) {
        ml = arg;
    }

    @Override
    public boolean ClickButton() {
        // TODO Auto-generated method stub
        return button;
    }

    @Override
    public boolean MoveMouse() {
        // TODO Auto-generated method stub
        return mouse;
    }

    // 触发事件
    public void buttonEventHappened() {
        button = true;
        ml.doEvent(this);
    }

}
