package com.ben.java.core.lambda;

public class ThreadUtils {
    public static void addShutdownHook(Runnable runnable) {
        Runtime.getRuntime().addShutdownHook(new Thread(runnable));
    }
}
