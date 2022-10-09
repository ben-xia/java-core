package com.ben.java.core.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的任务会在队列中等待。
 *
 * @author Administrator
 * @date 2018年7月23日
 */
public class ThreadPoolExecutorTest02 {
    public static void main(String[] args) throws Exception{
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {  //提交任务,执行任务,分两步走
                public void run() {
                    try {
                        System.out.println("线程名称:" + Thread.currentThread().getName() + ",\t执行时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "\t|\t" + index);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
