package com.ben.java.core.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author ben-xia
 * @date 2019/11/18
 * @Description TODO
 **/
public class CacheHealthChecker extends BaseHealthChecker {
    public CacheHealthChecker(CountDownLatch latch) {
        super("Cache Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}
