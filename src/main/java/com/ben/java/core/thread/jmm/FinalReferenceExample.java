package com.ben.java.core.thread.jmm;
/**
 * 在上图中，1是对final域的写入，2是对final域引用的对象的成员域的写入，3是把被构造的对象的引用赋值给某个引用变量。这里1和3，2和3都不能重排序。
 * JMM可以保证读线程C至少能看到写线程A在构造函数中国对final引用对象的成员域的写入。即线程C至少能看到数组下标0的值为1。线程B对数组元素的写入，读线程C不一定能保证看到。
 * 要想保证读线程C看到线程B对数组元素的写入，写线程B和读线程C之间需要使用同步原语（lock或volatile）保证内存可见性。
 * 
 * @author Administrator
 * @date   2019年4月1日
 */
public class FinalReferenceExample {
	final int[] intArray; // final 是引用类型
	static FinalReferenceExample obj;

	public FinalReferenceExample() { // 构造函数
		intArray = new int[1]; // 1
		intArray[0] = 1; // 2
	}

	public static void writerOne() { // 写线程A执行
		obj = new FinalReferenceExample();// 3
	}

	public static void writeTwo() { // 写线程B执行
		obj.intArray[0] = 2; // 4
	}

	public static void reader() { // 读线程C执行
		if (obj != null) { // 5
			int temp1 = obj.intArray[0];// 6
		}
	}
}
