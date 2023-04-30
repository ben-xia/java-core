package com.ben.java.gof.structural_model.flyweight.jdk;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/4/30
 */
public class StringTest {
    public static void main(String[] args) {
        //能在编译阶段确定的会在编译阶段静态得分配内存地址和值并做一定优化,编译阶段只能识别值,无法识别地址
        // 常量都是可以在编译阶段确认值和地址的,
        //变量,顾名思义变化的, 它只能在运行时分配值和内存地址
        //这些字母在编译阶段就能识别,并放入常量池
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "ab" + "c";
        String s4 = "ab" + new String("c");
        String s5 = new String("abc");
        String s6 = s5.intern(); //拿到s5的值得常量地址

        String s7 = "a";
        String s8 = "bc";
        String s9 = s7 + s8;

        System.out.println(s1 == s2); // true  JDK内部提供了一个常量池
        System.out.println(s1 == s3); // true
        System.out.println(s1 == s4); // true
        System.out.println(s1 == s5); // true
        System.out.println(s1 == s6); // true
        System.out.println(s1 == s9); // true
    }
}
