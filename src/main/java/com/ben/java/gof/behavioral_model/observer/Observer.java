package com.ben.java.gof.behavioral_model.observer;

/**
 * 观察者(打进毒枭集团的内奸,负责监视毒枭的一举一动,如陈永仁)
 */
public interface Observer {
    /*拉模式*/
//    public void updateStatus(Subject subject);

    /*推模式*/
//    public void updateContent(String content);

    /*Object... object:不定参数*/
    public void update(Subject subject, Object... object);
}
