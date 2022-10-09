package com.ben.java.core.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * java.lang.reflect.Method 类中的方法
 * 
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class MethodTest06 {

	public static void main(String[] args) throws Exception, SecurityException {
		
//		Class cl = CustomerService.class;
		Class cl = java.util.Date.class;
		
		Method[] declaredMethods = cl.getDeclaredMethods();
//		for (Method method : declaredMethods) {
//			//获取修饰符
//			System.out.println(Modifier.toString(method.getModifiers()));
//			//返回值类型
//			System.out.println(method.getReturnType().getName());
//			//获取方法名
//			System.out.println(method.getName());
//			
//			Class<?>[] parameterTypes = method.getParameterTypes();
//			for (Class<?> c1 : parameterTypes) {
//				System.out.println(c1.getSimpleName());
//				
//				
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(Modifier.toString(cl.getModifiers()) + " class " + cl.getSimpleName() + "{\n");
		for (Method method : declaredMethods) {
			sb.append("\t" + Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName());
			sb.append("(" );
			Class<?>[] parameterTypes = method.getParameterTypes();
			for (int i = 0; i < parameterTypes.length; i++) {
				if (i == parameterTypes.length -1) {
					sb.append(parameterTypes[i].getSimpleName()+ "");
				}else {
					sb.append(parameterTypes[i].getSimpleName()+ ",");
				}
				
			}
			sb.substring(sb.length()-2, sb.length()-1);
			sb.append(")" );
			sb.append("{}\n" );
		}
		
		sb.append("}");
		System.out.println(sb.toString());

	}

}
