package com.ben.java.gof.structural_model.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {

	public ProxyFactory() {
	}

	public Object createProxy(Object target) {
		// 使用CGLIB创建代理对象

		// 创建Enhancer对象,增强器
		Enhancer en = new Enhancer();

		// 指定父类,即目标类
		en.setSuperclass(target.getClass());

		// 指定方法拦截器对象
		en.setCallback(new MyMethodInterceptor(target));

		// 创建代理对象
		return en.create();
	}

}
