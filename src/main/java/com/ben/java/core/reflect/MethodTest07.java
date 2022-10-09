package com.ben.java.core.reflect;

import java.lang.reflect.Method;

/**
 * java.lang.reflect.Method 类中的指定方法
 * 
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class MethodTest07 {

	public static void main(String[] args) throws Exception {

		Class cl = CustomerService.class;
		Method m = cl.getDeclaredMethod("login", String.class, String.class);
		Object o = cl.newInstance();
		Object res = m.invoke(o, "admin", "123456");
		System.out.println(res);

	}

}
