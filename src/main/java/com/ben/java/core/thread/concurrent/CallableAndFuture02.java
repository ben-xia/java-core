package com.ben.java.core.thread.concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Callable和Future，它俩很有意思的，都可以拿到异步执行的结果。      
 * Callable接口类似于Runnable，从名字就可以看出来了，但是Runnable不会返回结果，并且无法抛出返回结果的异常，
 * 而Callable功能更强大一些，被线程执行后，可以返回值，这个返回值可以被Future拿到，也就是说，Future可以拿到异步执行任务的返回值
 * 
 * @author ben xia
 *
 */
public class CallableAndFuture02 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Future<Integer> future = exec.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				return new Random().nextInt(100);
			};
		});

		try {
			exec.shutdown();
			Integer ret = future.get();
			System.out.println(ret);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
