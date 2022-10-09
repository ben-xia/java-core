package com.ben.java.core.thread.jmm;

public class FinalExample {

	int i; // 普通变量

	final int j; // final变量

	static FinalExample obj;

	public FinalExample() { // 构造函数
		i = 1; // 写普通域
		j = 2; // 写final域
	}

	public static void writer() {// 写线程A执行
		obj = new FinalExample();
	}
	/**
	 * reader()方法包含3个步骤：
     *
	 * ①初次读引用变量obj
	 * ②初次读引用变量obj指向对象的普通域 i
	 * ③初次读引用变量obj指向对象的final域 j
	 */
	public static void reader() { // 读线程B执行
		FinalExample object = obj; // 读对象引用
		int a = object.i; // 读普通域
		int b = object.j; // 读final域
		System.out.println("a==" + a +",b==" + b);
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				reader();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				writer();
			}
		});
		
		t1.start();
		t2.start();
	}
}
