package com.ben.java.core.reflect;

import java.lang.reflect.Constructor;

/**
 * java.lang.reflect.constructor 类中的某个构造方法
 * 
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class ConstructorTest09 {

	public static void main(String[] args) throws Exception, SecurityException {

		Class cl = User.class;

		Constructor con = cl.getDeclaredConstructor(String.class, Integer.class, String.class, Boolean.class);

		Object o = con.newInstance("abc", 20, "dfg", true);
		
		System.out.println(o);

	}

}
