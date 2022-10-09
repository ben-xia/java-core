package com.ben.java.core.thread.interrupt;

public class ThreadStopUnSafe {
    public static User user = new User();

    // 改变user变量的线程
    public static class ChangeObjectThread extends Thread {
        @Override
        public void run() {

            while (true) {
                //执行完上面的synchronized语句块就释放了ThreadStopUnSafe.class类锁;
                synchronized (ThreadStopUnSafe.class) {
                    int v = (int) (System.currentTimeMillis() / 1000);
                    user.setId(v);
                    // to do sth
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    user.setName(String.valueOf(v));
                }
                // 让出CPU，给其他线程执行
                Thread.yield();
            }

        }

    }

    // 读取user变量的线程
    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {


            while (true) {
                //执行完上面的synchronized语句块就释放了ThreadStopUnSafe.class类锁;
                synchronized (ThreadStopUnSafe.class) {
                    if (user.getId() != Integer.parseInt(user.getName())) {
                        System.out.println(user.toString());
                    }
                }
                // 让出CPU，给其他线程执行
                Thread.yield();
            }

        }
    }


    // 测试
    public static void main(String[] args) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread t = new ChangeObjectThread();
            t.start();
            System.err.println(">>>>>>" + t.getName());
            Thread.sleep(150);
            // 使用stop()方法，强制停止线程
            t.stop();
//			t.interrupt();
        }
    }
}
