package com.ben.java.gof.structural_model.flyweight.jdk;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/4/30
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = Integer.valueOf(100);  //源码: 是返回值(引用类型自动拆箱)还是引用
        Integer b = 100;

        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println(a==b);
        System.out.println(c==d);
    }
}
