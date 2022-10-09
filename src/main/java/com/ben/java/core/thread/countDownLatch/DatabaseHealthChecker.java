package com.ben.java.core.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author ben-xia
 * @date 2019/11/18
 * @Description TODO
 **/
public class DatabaseHealthChecker extends BaseHealthChecker {
    public DatabaseHealthChecker(CountDownLatch latch) {
        super("Database Service", latch);
    }

    @Override
    public void verifyService() {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + " is UP");
    }
}