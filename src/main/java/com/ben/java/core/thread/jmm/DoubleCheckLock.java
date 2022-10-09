package com.ben.java.core.thread.jmm;

public class DoubleCheckLock {
	
	//需要加上修饰符:volatile
	private static  DoubleCheckLock instance;

	private DoubleCheckLock() {
	}

	public static DoubleCheckLock getInstance() {

		// 第一次检测
		if (instance == null) {
			// 同步
			synchronized (DoubleCheckLock.class) {
				if (instance == null) {
					// 多线程环境下可能会出现问题的地方(指令重排:只能保证单线程运行时的语义的正确性,所以多线程模式下需要禁止指令的重排)
					instance = new DoubleCheckLock();
				}
			}
		}
		return instance;
	}
}
