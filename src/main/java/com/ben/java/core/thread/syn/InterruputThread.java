package com.ben.java.core.thread.syn;

import java.util.concurrent.TimeUnit;

/**
 * 中断:处于运行期且非阻塞的状态的线程
 * 虽然我们调用了interrupt方法，但线程t1并未被中断，因为处于非阻塞状态的线程需要我们手动进行中断检测并结束程序，
 * */
public class InterruputThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				while (true) {
						if (this.isInterrupted()){
						System.out.println("线程已中断!!!");
						break;
					}
				}
				System.out.println("已跳出循环,线程被中断!!!");
			}
		};
		t1.start();
		TimeUnit.SECONDS.sleep(2);
		t1.interrupt();

		/**
		 * 输出结果(无限执行): 未被中断 未被中断 未被中断 ......
		 */
	}
}
