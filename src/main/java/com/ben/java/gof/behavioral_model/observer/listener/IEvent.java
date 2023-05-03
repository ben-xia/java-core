package com.ben.java.gof.behavioral_model.observer.listener;

/**
 * @author ben-xia
 * @desc  事件
 * @date 2019/5/19
 */
public interface IEvent {

    //1.给事件源注册监听器
    void setEventListener(IEventListener arg);

    //2.组件接受外部作用，也就是事件被触发
    boolean ClickButton();

    boolean MoveMouse();

}
