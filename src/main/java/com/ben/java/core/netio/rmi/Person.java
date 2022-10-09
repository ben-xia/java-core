package com.ben.java.core.netio.rmi;

/**
 * @author ben-xia
 * @date 2019/6/19
 * @desc dubbo中的接口(api),客户端和服务端都需要引入
 */
public interface Person{
    public int getAge() throws Throwable;
    public String getName() throws Throwable;
}
