package com.ben.java.gof.behavioral_model.strategy.v1;

/**
 * @author ben-xia
 * @date 2019/10/23
 * @Description TODO
 **/
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.operate();
        context.setContext(new GivenGreenLight());
        context.operate();
        context.setContext(new BlockEnemy());
        context.operate();
    }

}
