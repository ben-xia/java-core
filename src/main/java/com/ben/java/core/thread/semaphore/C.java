package com.ben.java.core.thread.semaphore;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author ben-xia
 * @date 2020/04/05
 * @Description TODO
 **/
public class C {
};

class A implements Runnable{
    private LinkedBlockingQueue<String> queue;
    private String content;
    private int queueSize;
    private Semaphore mutex;
    private Semaphore full;
    private Semaphore empty;

    @Override
    public void run() {

    }
};

class B implements Runnable{
    private LinkedBlockingQueue<String> queue;
    private Semaphore mutex;
    private Semaphore full;
    private Semaphore empty;

    @Override
    public void run() {

    }
}

