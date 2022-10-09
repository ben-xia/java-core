package com.ben.java.core.netio.rmi;

/**
 * 服务端接口服务
 * @author ben-xia
 * @date 2019/6/19
 */
public class PersonServer implements Person{
    private int age;
    private String name;

    public PersonServer(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
