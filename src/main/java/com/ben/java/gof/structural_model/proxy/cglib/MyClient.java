package com.ben.java.gof.structural_model.proxy.cglib;


public class MyClient {

    public static void main(String[] args) throws Exception {
        // 创建目标对象
        SomeService target = new SomeService();

        // 使用工厂方法创建代理对象
        ProxyFactory factory = new ProxyFactory();
        SomeService proxy = (SomeService) factory.createProxy(target);
        System.out.println("proxy:" + proxy.getClass().getName());

        // 通过代理对象执行业务方法
        String res = proxy.doSome();
        System.out.println("通过代理对象执行目标方法的结果:" + res);

    }

}
