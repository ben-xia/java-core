package com.ben.java.gof.structural_model.adapter;

import java.util.concurrent.Callable;

/**
 * @author ben-xia
 * @date 2021/04/24
 * @Description 编写一个Adapter的步骤如下：
 * 实现目标接口，这里是Runnable；
 * 内部持有一个待转换接口的引用，这里是通过字段持有Callable接口；
 * 在目标接口的实现方法内部，调用待转换接口的方法。
 **/
public class RunnableAdapter implements Runnable {
    // 引用待转换接口:
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    // 实现指定接口:
    public void run() {
        // 将指定接口调用委托给转换接口调用:
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            new Thread(new RunnableAdapter(new Task(10L))).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<Long> {
    private long num;

    public Task(long num) {
        this.num = num;
    }

    public Long call() throws Exception {
        long r = 0;
        for (long n = 1; n <= this.num; n++) {
            r = r + n;
        }
        System.out.println("Result: " + r);
        return r;
    }
}