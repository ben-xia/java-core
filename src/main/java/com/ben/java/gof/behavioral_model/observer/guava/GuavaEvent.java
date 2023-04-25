package com.ben.java.gof.behavioral_model.observer.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent{

    @Subscribe
    public void observer(Object org){
        System.out.println("执行observer方法,方法参数为:" +org);
    }
}
