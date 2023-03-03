package com.ben.java.core.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/2/25
 */
public class Person implements Serializable,Cloneable{
    private static final long serialVersionUID = 1L;
    private String name;
    private transient Integer age;

    public Person() {
        System.out.println("无参构造");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    //getter setter方法省略...
    @Override
    public String toString() {
        return "[" + name + ", " + age + "]";
    }

    //自定义序列化
    private void writeObject(ObjectOutputStream out)
            throws IOException {
        // 将当前类的非静态和非瞬态字段写入此流。
        //如果不写，如果还有其他字段，则不会被序列化
        // out.defaultWriteObject();

        out.writeObject(new StringBuffer(name).reverse());
        //将name简单加密（即反转），这样别人就知道是怎么回事，
        // 当然实际应用不可能这样加密。
        out.writeInt(age);
    }


    //反序列化
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        // 从此流读取当前类的非静态和非瞬态字段。
        //如果不写，其他字段就不能被反序列化
        //in.defaultReadObject();

        //解密:即简单的反转
        name = ((StringBuffer) in.readObject()).reverse().toString();
        age = in.readInt();
    }

}
