package com.ben.java.gof.structural_model.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * https://www.jb51.net/article/129142.htm
 * https://www.jianshu.com/p/d0ee1ca57f14
 * @author ben xia
 * @date 2018年10月3日上午8:46:55
 */
public class MyClient {

	public static void main(String[] args) throws Exception{
		// 创建目标对象
		SomeService target = new SomeServiceImpl();
		// 创建调用处理器对象
		MyInvocationHandler handler = new MyInvocationHandler(target);

		// 使用Proxy,创建代理对象 
		//第一个参数是:目标类的类加载器,通过目标对象的反射可获取;
		//第二个参数是:目标类实现的接口数组,通过目标对象的反射可获取;
		//第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
		//Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
		//
		//动态代理的代理对象是在内存中的
		//
		
		SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), handler);

		//这里可以看出proxy的Class类是$Proxy0,这个$Proxy0类继承了Proxy，实现了SomeService接口
		System.out.println("proxy的Class类是:" +proxy.getClass().getName() );

		Field[] field=proxy.getClass().getDeclaredFields();
		for(Field f:field){
			System.out.print(f.getName()+", ");
		}

		System.out.print("\n"+"proxy中的方法有：");

		Method[] method=proxy.getClass().getDeclaredMethods();

		for(Method m:method){
			System.out.print(m.getName()+", ");
		}

		System.out.println("\n"+"proxy的父类是："+proxy.getClass().getSuperclass());

		System.out.print("\n"+"proxy实现的接口是：");

		Class<?>[] interfaces=proxy.getClass().getInterfaces();

		for(Class<?> i:interfaces){
			System.out.print(i.getName()+", ");
		}

		System.out.println("\n\n"+"运行结果为：");
		// 通过代理对象调用业务方法
		proxy.doSome();

		// 这里我们将jdk生成的代理类输出了出来，方便后面分析使用
		byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{SomeServiceImpl.class});

		FileOutputStream os = new FileOutputStream("D:\\Proxy0.class");
		os.write(bytes);
		os.close();
	}

}
