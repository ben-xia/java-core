package com.ben.java.core.reflect;

import java.lang.reflect.Field;

/**
 * java.lang.reflect.Field 类中的属性
 * 
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class FieldTest05 {

	public static void main(String[] args) throws Exception, SecurityException {

		// 以前的方式
		// User user = new User();
		// user.age =23; //set
		// System.out.println(user.age); //get

		Class c1 = User.class;   //c1代表的一个具体的Java类

		// 获取某个特定的属性
		Field declaredField = c1.getDeclaredField("id");

		// 获取到了某个特定的属性,可以用来? 可以用来设值(set)和取值(get)
		Object o = c1.newInstance();  // c1.newInstance()创建一个具体的对象
		
		//反射可以打破封装[导致了JAVA对象的属性不安全]
		//注意declaredField.setAccessible(true)这行代码，通过调用setAccessible()方法会关闭指定类Field实例的反射访问检查，
		// 这行代码执行之后不论是私有的、受保护的以及包访问的作用域，你都可以在任何地方访问，即使你不在他的访问权限作用域之内。
		// 但是你如果你用一般代码来访问这些不在你权限作用域之内的代码依然是不可以的，在编译的时候就会报错。
		declaredField.setAccessible(true);
		
		//给o这个对象的declaredField属性设值为"120"
		declaredField.set(o, "120");
		
		//从o这个对象中取declaredField属性
		Object object = declaredField.get(o);
		
		System.out.println(object);

	}

}
