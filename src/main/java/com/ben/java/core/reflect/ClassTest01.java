package com.ben.java.core.reflect;

import java.util.Date;

/**
 * 通过反射去创建JAVA对象,都是通过调用类的无参数构造方法
 * 
 * 获取对应类的Class对象的三种方式: Class类型类的实例就是.class文件
 * 
 * @author ben xia
 * @email keeping1990@126.com
 * @date 2018年10月3日上午8:46:55
 * @version
 */
public class ClassTest01 {
	public static void main(String[] args) throws Exception{
		// 类加载: 将Date.class加载到JVM中,会执行静态语句块
		// 获取对应类的Class对象
		Class<?> cl = Class.forName("java.util.Date"); // 全限定类名

		// 不会执行静态语句块
		// 获取对应类的Class对象
		//这种方法相对其它两种方法更加简单，更安全。
		Class c2 = Date.class;

		Date date = new Date();
		// 获取对象对应类的Class对象
		Class c3 = date.getClass();

		// newInstance() 创建此Class对象所表示的类的一个新实例
		Object instance = cl.newInstance(); // 调用Date的无参数构造方法来创建对象[反射机制]
		System.out.println(instance);
		System.out.println(cl == c2 && c2 == c3);


	}
}
