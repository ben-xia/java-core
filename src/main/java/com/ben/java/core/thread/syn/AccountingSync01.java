package com.ben.java.core.thread.syn;
/**
 * synchronized作用于示例方法
 * */
public class AccountingSync01 implements Runnable {
	static int i =0 ; //类变量,所有对象共享的变量,类加载的时候分配空间并初始化
	
	public synchronized void increase(){
		i ++;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			increase();
		}

	}
	
	public static void main(String[] args) throws InterruptedException {
		AccountingSync01 acc = new AccountingSync01();
		//将某个任务分配给某个线程执行
		Thread t1 = new Thread(acc);
		Thread t2 = new Thread(acc);
		
		t1.start(); //其实最终调用的还是run()方法,run()方法在调用其它的方法;run方法也是一个实例方法;
		t2.start();
		
		//将指定线程t1,t2加入到当前线程,此处当前线程即主线程;只有在t1和t2的方法执行完毕之后才会才会继续执行当前线程
		//此处表示只有t1,t2线程执行完毕之后才会执行主线程的打印输出,否则就阻塞
		t1.join();
		t2.join();
		System.out.println("i=" + i);
		
		
	}

}
