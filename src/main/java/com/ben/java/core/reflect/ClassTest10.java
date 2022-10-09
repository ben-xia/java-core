package com.ben.java.core.reflect;

/**
 * 通过反射获取类的父接口和父类
 * 
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class ClassTest10 {

	public static void main(String[] args) throws Exception, SecurityException {

		Class cl = String.class;

		Class superclass = cl.getSuperclass();
		System.out.println(superclass.getName());

		Class[] interfaces = cl.getInterfaces();
		for (Class c2 : interfaces) {
			System.out.println(c2.getName());
		}

	}

}
