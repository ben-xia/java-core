package com.ben.java.core.thread.aqs;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * new Thread(new Runnable(new condition()))
 */
public class Mutil_Producer_ConsumerByCondition2 {

	public static void main(String[] args) {
		int queueSize = 200;
		PriorityQueue<Integer> queue = new PriorityQueue(queueSize);
		Lock lock = new ReentrantLock();
		Condition produce = lock.newCondition();
		Condition consume = lock.newCondition();

		Consumer2 consumer1 = new Consumer2(queue, lock, produce, consume);
		Consumer2 consumer2 = new Consumer2(queue, lock, produce, consume);
		Producer2 producer2 = new Producer2(queue, queueSize, lock, produce, consume);
		Producer2 producer1 = new Producer2(queue, queueSize, lock, produce, consume);
		
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(producer1).start();
		new Thread(producer2).start();
	}
}

class Producer2 implements Runnable {
	private PriorityQueue<Integer> queue = null;
	private int queueSize = 0;
	private Lock lock = null;
	private Condition consume = null;
	private Condition produce = null;

	public Producer2(PriorityQueue<Integer> queue, int queueSize, Lock lock, Condition produce, Condition consume) {
		this.queue = queue;
		this.queueSize = queueSize;
		this.lock = lock;
		this.consume = consume;
		this.produce = produce;
	}

	public void product() {
		while (true) {
			lock.lock();
			try {
				while (queue.size() == queueSize) {
					System.out.println("队列满了，等待消费者消费...");
					try {
						produce.await();  //当前线程等待在produce等待池中;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						consume.signal();
					}
				}
				queue.offer(1);
				System.out.println(Thread.currentThread().getName()+" - 向队列中插入了一个对象，队列的剩余空间是：" + (queueSize - queue.size()));
				consume.signal();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} finally {
				lock.unlock();
			}
		}
	}

	@Override
	public void run() {
		this.product();
	}
}

class Consumer2 implements Runnable {
	private PriorityQueue<Integer> queue = null;
	private Lock lock = null;
	private Condition consume = null;
	private Condition produce = null;

	public Consumer2(PriorityQueue<Integer> queue, Lock lock, Condition produce, Condition consume) {
		this.queue = queue;
		this.lock = lock;
		this.consume = consume;
		this.produce = produce;
	}

	private void consume() {
		while (true) {
			lock.lock();
			try {
				while (queue.size() == 0) {
					System.out.println("队列为空，等待数据...");
					try {
						consume.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						produce.signal();
					}
				}
				queue.poll();
				System.out.println(Thread.currentThread().getName()+" - 从队列中取出一个元素，队列剩余数量是：" + queue.size());
				produce.signal();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				lock.unlock();
			}
		}
	}

	@Override
	public void run() {
		this.consume();
	}

}
