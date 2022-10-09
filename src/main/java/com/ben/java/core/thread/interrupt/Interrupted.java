package com.ben.java.core.thread.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Interrupted {
    public static void main(String[] args) throws Exception {
        // sleepThread不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);
        // busyThread不停的运行
        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        // 休眠5秒，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(60);
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread interrupted is "
                + sleepThread.isInterrupted());  //false
        System.out.println("BusyThread interrupted is "
                + busyThread.isInterrupted());  //true
        // 防止sleepThread和busyThread立刻退出
        TimeUnit.SECONDS.sleep(2);
        System.out.println("-------------------------------");
        System.out.println("SleepThread interrupted is "
                + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "
                + busyThread.isInterrupted());
        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            final AtomicInteger integer = new AtomicInteger(0);
            boolean flag=true;
            while (true) {
                try {
                    if (flag) TimeUnit.SECONDS.sleep(10);
                    System.out.println("------" + integer.incrementAndGet());
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println("线程状态: " + Thread.currentThread().getState().name());
                    System.out.println("线程状态: " + Thread.currentThread().isInterrupted());
//                    flag=false;
                }
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
}
