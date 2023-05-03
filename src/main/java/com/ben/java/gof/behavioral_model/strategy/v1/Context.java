package com.ben.java.gof.behavioral_model.strategy.v1;

/**
 * @author ben-xia
 * @date 2019/10/23
 * @Description TODO
 **/
public class Context {
    //默认策略
    private IStrategy straegy =new BackDoor();

    //构造函数，你要使用那个妙计
    public void setContext(IStrategy strategy){
        this.straegy = strategy;
    }
    //使用计谋了，看我出招了
    public void operate(){
        this.straegy.operate();
    }
}
