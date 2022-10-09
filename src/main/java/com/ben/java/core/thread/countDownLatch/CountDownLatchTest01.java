package com.ben.java.core.thread.countDownLatch;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ben-xia
 * @date 2019/11/18
 * @Description TODO
 **/
public class CountDownLatchTest01 {

    private final static CountDownLatch cdl = new CountDownLatch(3);
    private final static Vector v = new Vector();
    private final static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());//使用线程池

    private static class WriteThread extends Thread {
        private final String writeThreadName;
        private final int stopTime;
        private final String str;

        public WriteThread(String name, int time, String str) {
            this.writeThreadName = name;
            this.stopTime = time;
            this.str = str;
        }

        public void run() {
            System.out.println(writeThreadName + "开始写入工作");
            try {
                Thread.sleep(stopTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            v.add(str);
            cdl.countDown();
            System.out.println(writeThreadName + "写入内容为：" + str + "。写入工作结束！");
        }
    }

    private static class ReadThread extends Thread {
        public void run() {
            System.out.println("读操作之前必须先进行写操作");
            try {
                cdl.await();//该线程进行等待，直到countDown减到0，然后逐个苏醒过来。
                //Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < v.size(); i++) {
                System.out.println("读取第" + (i + 1) + "条记录内容为：" + v.get(i));
            }
            System.out.println("读操作结束！");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread read = new ReadThread();
        threadPool.execute(read);
        String[] str = {"多线程知识点", "多线程CountDownLatch的知识点", "多线程中控制顺序可以使用CountDownLatch"};


        for (int i = 0; i < 3; i++) {
            Thread t1 = new WriteThread("writeThread" + (i + 1), 1000 * (i + 1), str[i]);
            threadPool.execute(t1);
        }
    }

}