package com.ben.java.gof.structural_model.proxy.statics;

public class Client {
    public static void main(String[] args) {
        Target target = new TargetProxy(new TargetImpl());
        target.doSomething();

    }
}
