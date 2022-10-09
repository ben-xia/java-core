package com.ben.java.core.thread.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock:显示锁
 * ReentrantLock:重入锁,与synchronized相当,但是比synchronized灵活和多功能
 */
public class ReenterLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static int j = 0;

	@Override // 其实是一个成员方法
	public void run() {
		for (int i = 0; i < 10000; i++) {
			lock.lock();
			lock.lock();
			
			try {
				j++;
			} finally {
				lock.unlock();
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock instance = new ReenterLock();
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("j>>>>>" + j);
		
	}

}
