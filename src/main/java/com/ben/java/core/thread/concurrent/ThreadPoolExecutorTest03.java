package com.ben.java.core.thread.concurrent;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行
 * Java标准库还提供了一个java.util.Timer类，这个类也可以定期执行任务，但是，一个Timer会对应一个Thread，
 * 所以，一个Timer只能定期执行一个任务，多个定时任务必须启动多个Timer，而一个ScheduledThreadPool就可以调度多个定时任务，
 * 所以，我们完全可以用ScheduledThreadPool取代旧的Timer。
 * @author Administrator
 * @date 2018年7月23日
 */
public class ThreadPoolExecutorTest03 {
	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		scheduledThreadPool.scheduleAtFixedRate(new Runnable() {

			@SneakyThrows
			@Override
			public void run() {
				System.out.println("线程名称:\t"+Thread.currentThread().getName()+",执行时间:\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
				Thread.sleep(2000);
			}
		}, 5, 1, TimeUnit.SECONDS);

	}
}
