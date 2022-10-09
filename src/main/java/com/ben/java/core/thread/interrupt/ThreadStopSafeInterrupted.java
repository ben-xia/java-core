package com.ben.java.core.thread.interrupt;

/**
 * 中断: 可以中断出于任何状态下的线程
 * 调用线程实例的interrupt()方法去中断正在sleep()的实例线程的内部细节:
 * t线程正在sleep,在另外一个线程中调用t.interrupt(),将t线程的中断标识设置为true,
 * 但是JVM会先将线程的中断标识清除[即设置为false],然后抛出InterruptedException,
 * 如果不加处理,那么下一次循环开始的时候,就无法捕获到这个异常,故需要再异常处理中, 再次设置中断标识,线程才最终被中断;
 * [如果某个线程正在运行,调用线程实例的interrupt()方法一次性就可以设置中断标识为true]
 * 
 * @author Administrator
 *
 */
public class ThreadStopSafeInterrupted {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while (true) {
					// 使用中断机制，来终止线程
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted ...");
						break;
					}

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {  //
						System.out.println("Interrupted When Sleep ...");
						// Thread.sleep()方法由于中断抛出异常。
						// Java虚拟机会先将该线程的中断标识位清除，然后抛出InterruptedException，
						// 因为在发生InterruptedException异常的时候，会清除中断标记
						// 如果不加处理，那么下一次循环开始的时候，就无法捕获这个异常。
						// 故在异常处理中，再次设置中断标记位
						System.out.println("while="+Thread.currentThread().isInterrupted());
						Thread.currentThread().interrupt();
					}
					System.out.println(">>>>>>>>>>>>>>>" + System.currentTimeMillis());

				}
			}
		};

		// 开启线程
		thread.start();
		Thread.sleep(2000);
		thread.interrupt();

	}

}
