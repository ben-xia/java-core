package com.ben.java.core.thread.countDownLatch;

/**
 * @author ben-xia
 * @date 2019/11/18
 * @Description TODO
 **/
public class Main {
    public static void main(String[] args)
    {
        boolean result = false;
        try {
            result = ApplicationStartupUtil.checkExternalServices();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("External services validation completed !! Result was :: "+ result);
    }
}

/** --- print ---
 Checking Network Service
 Checking Cache Service
 Checking Database Service
 Database Service is UP
 Cache Service is UP
 Network Service is UP
 External services validation completed !! Result was :: true
 **/
