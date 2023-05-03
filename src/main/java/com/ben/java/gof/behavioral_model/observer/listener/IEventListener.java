package com.ben.java.gof.behavioral_model.observer.listener;

/**
 * @author ben-xia
 * @desc   事件监听器，事件处理器
 * @date 2019/5/19
 */
public interface IEventListener {
    //3.组件产生一个相应的事件对象，并把此对象传递给与之关联的事件处理器
    //4、事件处理器启动，并执行相关的代码来处理该事件。
    void doEvent(IEvent arg);
}

