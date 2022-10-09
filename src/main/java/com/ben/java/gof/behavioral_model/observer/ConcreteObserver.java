package com.ben.java.gof.behavioral_model.observer;

public class ConcreteObserver implements Observer {
    private String observerStatus;

    public String getObserverStatus() {
        return observerStatus;
    }


    @Override
    public void update(Subject subject, Object... object) {
        observerStatus = ((ConcreteSubject) subject).getStatus();
        System.out.println("获取了目标对象的行动信息,给黄sir通报消息!");
//        observerStatus = object.toString();
    }
}
