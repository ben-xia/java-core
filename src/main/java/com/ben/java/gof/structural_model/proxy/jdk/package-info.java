/**
 * JDK的动态代理: 目标类必须实现接口
 * 
 * JDK的动态代理涉及的接口和类所在的包: java.lang.reflect
 * 1) Proxy类: 创建动态代理对象, Proxy.newProxyInstance(),创建动态代理对象.
 * 2) Method:  表示目标方法, invoke()执行的目标方法;
 * 3) InvocationHandler 接口:调用处理器,作用是截取对目标方法的调用,在实现类中
 * 							完成功能增强和控制访问;
 * 
 * 
 * 开发步骤:
 * 1)定义目标接口和实现类;
 * 2)定义调用处理器类,实现InvocationHandler接口;
 * 3)定义调用者类,使用Proxy创建动态代理对象;
 * 		使用动态代理对象,执行业务方法,增强功能;
 * 
 * 
 * 
 * 
 */
/**
 * @author ben xia
 * @email  keeping1990@126.com
 * @date   2018年10月1日下午5:38:45
 * @version 
 */
package com.ben.java.gof.structural_model.proxy.jdk;