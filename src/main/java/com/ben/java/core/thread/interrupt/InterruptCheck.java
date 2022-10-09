package com.ben.java.core.thread.interrupt;

/**
 * 设置中断标识 - 中断标识校验 - 中断响应
 */
public class InterruptCheck {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("A: isInterrupted=" + t.isInterrupted()); //false
		t.interrupt(); //设置是否有中断请求的标识为true
		System.out.println("B: isInterrupted=" + t.isInterrupted()); //true 检测线程的中断标识
		System.out.println("C: isInterrupted=" + t.isInterrupted()); //true
		try {
			//响应:能够对请求做出相应的回应
			t.sleep(2000);  //此处响应了中断,并且throw InterruptedException
			System.out.println("线程没有被中断"); 
		} catch (InterruptedException x) {
			System.out.println("线程被中断了");
		}
		System.out.println("D: isInterrupted=" + t.isInterrupted());  //false
	}
}
