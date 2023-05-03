package com.ben.java.gof.behavioral_model.strategy.v1;

/**
 * @author ben-xia
 * @date 2019/10/23
 * @Description 首先定一个策略接口，这是诸葛亮老人家给赵云的三个锦囊妙计的接口
 *
 * 策略模式就是在接口的基础之上用context在包裹一层,context中的方法与接口中的方法一一对应;
 **/
public interface IStrategy {
    //每个锦囊妙计都是一个可执行的算法
    public void operate();
}