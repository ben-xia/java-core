package com.ben.java.core.reflect;

import java.util.Random;

/**
 * 类的初始化[*****]
 * 
 * @author Administrator
 *
 */
public class ClassInitialization {
	public static Random rand = new Random(47);

	public static void main(String[] args) throws Exception {
		// 字面常量获取方式获取Class对象
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		// 不触发类初始化
		System.out.println(Initable.staticFinal);
		// 会触发类初始化
		System.out.println(Initable.staticFinal2);
		// 会触发类初始化
		System.out.println(Initable2.staticNonFinal);
		// forName方法获取Class对象
		Class initable3 = Class.forName("com.ben.java.reflect.Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
	}
}

class Initable3 {
	// 静态成员变量
	static int staticNonFinal = 74;
	static {
		System.out.println("Initializing Initable3");
	}
}

class Initable2 {
	// 静态成员变量
	static int staticNonFinal = 147;
	static {
		System.out.println("Initializing Initable2");
	}
}

class Initable {
	// 编译期静态常量
	static final int staticFinal = 47;
	// 非编期静态常量
	//注意staticFinal2虽然被static和final修饰，但其值在编译期并不能确定，因此staticFinal2并不是编译期常量，使用该变量必须先初始化Initable类。
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	static {
		System.out.println("Initializing Initable");
	}
}




