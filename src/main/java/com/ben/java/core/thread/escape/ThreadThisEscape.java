package com.ben.java.core.thread.escape;
/**
 * 书中还提到一种this引用逸出的情况是，在构造函数中启动一个线程。当对象在其构造函数中创建了一个线程时，
 * 无论显示创建（通过将它传给构造函数）还是隐式创建（由于Thread或Runnable是该对象的一个内部类），
 * this引用都会被新创建的线程共享。在对象尚未完全构造之前，新的线程就可以看到它。
 * @author Administrator
 * @date   2019年4月1日
 */
public class ThreadThisEscape {
	private int weight = 0;

	public ThreadThisEscape() {

		new Thread(new EscapeRunnable()).start();

		// 模拟构造函数耗时
		for (int i = 0; i < 1000000; i++) {

		}

		weight = 1;

	}

	private class EscapeRunnable implements Runnable {
		@Override
		public void run() {
			System.out.println(ThreadThisEscape.this.weight);
		}
	}

	public static void main(String[] args) {
		new ThreadThisEscape();
	}
}