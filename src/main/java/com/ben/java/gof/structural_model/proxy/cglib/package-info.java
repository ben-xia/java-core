/**
 * 使用CGLIB库生成动态代理:CGLIB生成动态代理的原理是通过继承,子类是代理类,
 * 在子类中完成功能的增强,要求目标类,目标方法不能是final;
 * 
 * 开发步骤:
 * 1.导入CGLIB库;
 * 2.定义目标类,不需要接口;
 * 3.定义方法拦截器(jdk动态代理中的调用处理器),实现的接口是MethodInterceptor;
 * 4.定义工厂方法,创建代理对象;  是使用Enhancer,创建代理对象;
 * 5.定义调用者类,使用代理对象,调用业务方法;
 * 
 */
/**
 * @author ben xia
 * @email  keeping1990@126.com
 * @date   2018年10月2日上午9:11:36
 * @version 
 */
package com.ben.java.gof.structural_model.proxy.cglib;