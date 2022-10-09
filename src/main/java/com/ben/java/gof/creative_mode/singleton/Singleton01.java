package com.ben.java.gof.creative_mode.singleton;

/**
 * 双重校验锁实现单例模式
 *
 * @author ben xia
 * @date 2018年7月6日
 */
public class Singleton01 {
    private static volatile Singleton01 instance;

    private Singleton01() {
    };

    public static Singleton01 getInstance() {
        if (instance == null) {
            synchronized (Singleton01.class) {
                if (instance == null) {
                    /**
                     * 由于编译器的优化、JVM的优化、操作系统处理器的优化，可能会导致指令重排（happen-before规则下的指令重排，执行结果不变，指令顺序优化排列）
                     * new Singleton01()这条语句大致会有这三个步骤：
                     * 1.在堆中开辟对象所需空间，分配内存地址
                     * 2.根据类加载的初始化顺序进行初始化
                     * 3.将内存地址返回给栈中的引用变量
                     *
                     * 但是由于指令重排的出现，这三条指令执行顺序会被打乱，可能导致3的顺序和2调换
                     */
                    instance = new Singleton01();
                }
            }
        }
        return instance;
    }

    ;

    public static void main(String[] args) {
        Singleton01 instance1 = Singleton01.getInstance();
        Singleton01 instance2 = Singleton01.getInstance();

        System.out.println(instance1);
        System.err.println(instance2);
    }
}
