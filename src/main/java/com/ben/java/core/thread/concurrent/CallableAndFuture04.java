package com.ben.java.core.thread.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 
 * @author ben xia
 *
 */
public class CallableAndFuture04 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		CompletionService<Integer> cs = new ExecutorCompletionService<>(exec);
		for (int i = 0; i < 5; i++) {
			cs.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println("线程名称:" + Thread.currentThread().getName() + ",\t执行时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
					return new Random().nextInt(100);
				}
			});
		}

		exec.shutdown();
		for (int i = 0; i < 5; i++) {
			try {
				Integer x = cs.take().get();
				System.out.println(x + "\t");
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
