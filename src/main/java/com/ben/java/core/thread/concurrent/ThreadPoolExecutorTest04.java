package com.ben.java.core.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newSingleThreadExecutor 创建一个单线程的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO,
 * LIFO, 优先级)执行。
 *
 * @author Administrator
 * @date 2018年7月23日
 */
public class ThreadPoolExecutorTest04 {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println("线程名称:" + Thread.currentThread().getName() + ",\t执行时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "\t|\t" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        singleThreadExecutor.shutdown();
    }
}
