package com.ben.java.core.thread.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 
 * @author ben xia
 *
 */
public class CallableAndFuture03 {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		// CompletionService<Integer> cs = new ExecutorCompletionService<>(exec);

		List<Future<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Future<Integer> future = exec.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					// TODO Auto-generated method stub
					return new Random().nextInt(100);
				};
			});
			list.add(future);
		}
		exec.shutdown();
		for (Future<Integer> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
