package com.ben.java.gof.structural_model.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 调用处理器类:截取对目标方法的访问
 * 
 * @author ben xia
 * @email keeping1990@126.com
 * @date 2018年10月1日下午5:56:30
 * @version
 */
public class MyInvocationHandler implements InvocationHandler {
	private Object target; // 目标对象

	public MyInvocationHandler() {
		super();

	}

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}


	/**
	 * 截取目标方法的访问 Object proxy; JVM生成的代理对象 
	 * Method method: 业务方法,即目标方法
	 * Object[] args:业务方法的参数列表
	 * Object : 返回值表示目标方法的执行结果(可以是修改后的结果,功能增强的结果)
	 * 
	 * 代理模式:
	 * 	1.控制访问,控制目标对象方法的调用
	 * 	2.功能的增强
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//		System.out.println("invoke()>>>>>>");
//        System.out.println("invoke(proxy)===" + proxy.getClass().getName());
		// 使用反射调用目标方法:
		Object invoke = method.invoke(target, args);
//		System.out.println(invoke);
		return invoke;
	}

}
