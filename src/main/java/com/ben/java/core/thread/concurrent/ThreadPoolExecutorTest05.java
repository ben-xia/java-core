package com.ben.java.core.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程调度原理就是CPU的时间片的轮转，休眠(sleep)就是让出当前线程的CPU的调度权限，
 * 然后供替他别的线程使用，就是不使用CPU了，进入下一轮的线程随机调度
 *
 * @author Administrator
 * @date 2018年7月23日
 */
public class ThreadPoolExecutorTest05 {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            Thread.sleep(10 * 1000);
                            System.err.println("线程名:\t" + Thread.currentThread().getName() + ",index=" + index);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        cachedThreadPool.shutdown();
        try {
            Thread.sleep(500);
            System.err.println("线程名:\t" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
