package com.ben.java.core.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorService继承自Executor，它的目的是为我们管理Thread对象，从而简化并发编程，Executor使我们无需显示的去管理线程的生命周期
 * CachedThreadPool在程序执行过程中通常会创建与所需数量相同的线程,然后在回收旧线程时停止 创建新线程,因此他是合理的Executor的首选;
 *
 * @author Administrator
 * @date 2018年7月23日
 */
public class ThreadPoolExecutorTest01 {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            cachedThreadPool.execute(new Runnable() {   //提交任务
                public void run() {   //线程池中的线程做的
                    System.out.println("线程名称:" + Thread.currentThread().getName() + ",\t执行时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "\t|\t" + index);
                }
            });
        }
        cachedThreadPool.shutdown();
    }
}
