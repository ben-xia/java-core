package com.ben.java.core.thread.syn;
/**
 * 一个类只有对应的一个锁
 * 一个对象只有对应的一个锁
 * */
public class AccountingSync implements Runnable{
    static AccountingSync instance1=new AccountingSync();
    static AccountingSync instance2=new AccountingSync();
    static int i=0;
    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized(AccountingSync.class){
            for(int j=0;j<1000000;j++){
                    i++;
              }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(instance1);
        Thread t2=new Thread(instance2);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}
