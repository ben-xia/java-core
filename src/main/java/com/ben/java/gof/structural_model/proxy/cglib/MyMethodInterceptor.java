package com.ben.java.gof.structural_model.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法拦截器
 */
public class MyMethodInterceptor implements MethodInterceptor {
	//目标对象
	private Object target;
	
	public MyMethodInterceptor() {
		super();
	}

	public MyMethodInterceptor(Object target) {
		super();
		this.target = target;
	}



	/**
	 * 拦截目标方法的调用,即实际执行该方法
	 * Object proxyObject: 生成的代理对象
	 * Method method     : 业务方法对象
	 * Object[] args     : 业务方法的参数列表
	 * MethodProxy proxy : 业务方法的代理对象
	 * 
	 * Object            : 目标的执行结果(可以是修改后的结果)
	 */
	@Override
	public Object intercept(Object proxyObject, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("目标方法执行前");

		Object result = method.invoke(target, args);

		System.out.println("目标方法执行后");
		return result;
	}

	
}
