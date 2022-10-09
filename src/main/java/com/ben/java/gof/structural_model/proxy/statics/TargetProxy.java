package com.ben.java.gof.structural_model.proxy.statics;

/**
 * 静态代理类(中间人)
 */
public class TargetProxy implements Target {
    private Target target;

    public TargetProxy(Target target) {
        this.target = target;
    }

    @Override
    public void doSomething() {
        before();
        target.doSomething();
        after();
    }

    private void before(){
        System.out.println("-------方法调用前执行---------");
    }
    private void after(){
        System.out.println("-------方法调用后执行---------");
    }
}
