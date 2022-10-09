package com.ben.java.core.guava.function.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author ben-xia
 * @date 2020/03/11
 * @Description https://www.cnblogs.com/haixiang/p/11029639.html
 *              语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda运算符 ，读作(goes to)
 **/
public class LambdaTest01 {
    @Test
    public  void testLambda01() {

        //新建线程
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        thread.start();

        System.out.println("----------------------------------------------");
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(11, "小牙刷", 12.05));
        items.add(new Item(5, "日本马桶盖", 999.05));
        items.add(new Item(7, "格力空调", 888.88));
        items.add(new Item(17, "肥皂", 2.00));
        items.add(new Item(9, "冰箱", 4200.00));

        //遍历
        items.forEach(System.out::println); // 类::静态方法; 对象::对象方法 [方法调用]
        //删除某个元素
        items.removeIf(item -> item.getCode() == 7);
        //排序
        items.sort((o1, o2) -> o1.getCode() - o2.getCode());
        items.forEach(System.out::println);

    }


    @Test
    public void testLambda02() {

        //Lambda 表达式中的闭包问题[*****]
        int num = 10;
        Consumer<String> consumer = ele -> {
            System.err.println(num);
        };

//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//              System.err.println(num);
//            }
//        };

        //num = num + 2;
        consumer.accept("hello");

    }




}
