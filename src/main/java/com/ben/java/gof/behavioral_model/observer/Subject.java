package com.ben.java.gof.behavioral_model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象:韩琛
 */
public abstract class Subject {
    /*观察者(内奸)列表: 如陈永仁*/
    protected List<Observer> observerList = new ArrayList<>();

    public abstract void add(Observer observer);

    public abstract void remove(Observer observer);

    /*韩琛告诉手下(包含内奸)我们今晚有行动*/
    public abstract void notifyobserver();

}
