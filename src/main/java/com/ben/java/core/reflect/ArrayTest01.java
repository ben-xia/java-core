package com.ben.java.core.reflect;

import java.lang.reflect.Array;

/**
 * java.lang.reflect.Array:操作数组的一个工具类
 */
public class ArrayTest01 {

    public static void main(String[] args) throws ClassNotFoundException {
        //Java反射机制通过java.lang.reflect.Array类来创建数组,
        //Array.newInstance()方法的第一个参数表示了我们要创建一个什么类型的数组。第二个参数表示了这个数组的空间是多大

        int[] intArray = (int[])Array.newInstance(int.class, 3);
        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);

        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));

        //获取数组的Class对象
        Class stringArrayClass01 = String[].class;

        //你可以像这样来获得一个原生数据类型（primitive）int数组的Class对象
        Class intArray01 = Class.forName("[I");

        // 在JVM中字母I代表int类型，左边的‘[’代表我想要的是一个int类型的数组，这个规则同样适用于其他的原生数据类型。
        // 对于普通对象类型的数组有一点细微的不同：

        Class stringArrayClass02 = Class.forName("[Ljava.lang.String;");




        // 获取数组的成员类型
        String[] strings = new String[3];
        Class stringArrayClass = strings.getClass();
        Class stringArrayComponentType = stringArrayClass.getComponentType();
        System.out.println(stringArrayComponentType);


    }
}
