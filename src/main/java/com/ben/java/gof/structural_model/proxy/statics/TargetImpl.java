package com.ben.java.gof.structural_model.proxy.statics;

public class TargetImpl implements  Target {
    @Override
    public void doSomething() {
        System.out.println("---------执行doSomething()------------");
    }
}
