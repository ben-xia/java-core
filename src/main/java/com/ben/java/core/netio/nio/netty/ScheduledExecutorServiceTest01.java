package com.ben.java.core.netio.nio.netty;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest01 {

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
	
		executor.scheduleAtFixedRate(new Runnable() {
			long i=0;
			@Override
			public void run() {
				System.out.println("这是第" +(++i) + "执行");
			}
		}, 10, 10, TimeUnit.SECONDS);
		
	}
}