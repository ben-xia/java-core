package com.ben.java.core.thread.concurrent;

import java.util.concurrent.*;

/**
 * FutureTask是一个RunnableFuture<V>[实现此接口],它实现Runnable和Futrue
 * <V>这两个接口,另外它还可以包装Runnable 和Callable
 * <V>,所以说它是一个复合体,它可以通过Thread包装来直接执行,也可以提交给ExecuteService来执行,并且还可以通过v get()
 * 返回异步执行结果,在线程体没有执行完成的时候,主线程一直阻塞等待,执行完则直接返回结果;
 * 
 * @author Administrator
 *
 */
public class FutureTaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Callable<String> task = new Callable<String>() {
			public String call() {
				System.out.println("Sleep start=" + System.currentTimeMillis());
				try {
					Thread.sleep(1000 * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Sleep end.");
				return "time=" + System.currentTimeMillis();
			}
		};

		//用FutureTask包装Callable/Runnable,既可以作为一个任务运行也可以用于获取异步任务的结果;
		FutureTask<String> ft = new FutureTask<String>(task);
		// 直接使用Thread的方式执行
		Thread t = new Thread(ft);
		t.start();
		try {
			System.out.println("waiting execute result");
			System.out.println("result = " + ft.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// 使用Executors来执行
		System.out.println("=========");
		FutureTask<String> ft2 = new FutureTask<String>(task);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.submit(ft2);
		executorService.shutdown();
		try {
			System.out.println("waiting execute result");
			System.out.println("result = " + ft2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}
