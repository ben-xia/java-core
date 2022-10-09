package com.ben.java.core.thread.aqs;

import java.util.concurrent.LinkedBlockingQueue;

public class Single_Producer_ConsumerByObject {

	public static void main(String[] args) {
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(100);
		Thread t1 = new Thread(new Pro(queue, "哈哈哈"));
		Thread t2 = new Thread(new Cons(queue));
		t1.start();
		t2.start();

	}

}

class Pro implements Runnable {
	public LinkedBlockingQueue<String> queue;
	public String content;

	public Pro(LinkedBlockingQueue<String> queue, String content) {
		super();
		this.queue = queue;
		this.content = content;
	}

	public void pro() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == 100) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						queue.notify();
						e.printStackTrace();
					}
				}
				queue.notify();
				queue.offer("哈哈哈");
				System.out.println("队列的存放的数量"+queue.size());
			}
		}

	}

	@Override
	public void run() {
		this.pro();

	}
}

class Cons implements Runnable {
	public LinkedBlockingQueue<String> queue;

	public Cons(LinkedBlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	public void con() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == 0) {
					try {
						queue.wait(); //阻塞线程并且释放锁
					} catch (InterruptedException e) {
						queue.notify();
						e.printStackTrace();
					}
				}

				queue.notify();
				try {
					String take = queue.take();
					System.err.println(">>>>>>>"+take+"____队列目前的数量"+queue.size());
				} catch (InterruptedException e) {
					queue.notify();
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		this.con();
	}
}
