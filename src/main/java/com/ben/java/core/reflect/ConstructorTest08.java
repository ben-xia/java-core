package com.ben.java.core.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * java.lang.reflect.constructor 类中的构造方法
 * 
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class ConstructorTest08 {

	public static void main(String[] args) throws Exception, SecurityException {

		Class cl = java.util.Date.class;
		
		Constructor[] declaredConstructors = cl.getDeclaredConstructors();
		
		StringBuilder sb = new StringBuilder();
		sb.append(Modifier.toString(cl.getModifiers()) + " class " + cl.getSimpleName() + " {\n");
		
		for (int i = 0; i < declaredConstructors.length; i++) {
			sb.append("\t");
			sb.append(Modifier.toString(declaredConstructors[i].getModifiers()) +" "+  cl.getSimpleName() + "(");
			
			Class[] parameterTypes = declaredConstructors[i].getParameterTypes();
			for (int j = 0; j < parameterTypes.length; j++) {
				if (j==parameterTypes.length -1) {
					
					sb.append(parameterTypes[j].getName());
				}else {
					
					sb.append(parameterTypes[j].getName() + ",");
				}
			}
			sb.append(")");
			sb.append("{}\n");
			
			
		}
		sb.append("}");
		System.out.println(sb.toString());
		
		

	}

}
