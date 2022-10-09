package com.ben.java.core.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 反射 + io + properties的联合使用 
 * 反射可以降低代码的耦合度,使代码更灵活
 * 
 * @date 2018年10月3日下午3:27:16
 */
public class ReflectTest03 {

	public static void main(String[] args) {
		Properties pro = new Properties();
		InputStream ins = null;

		ins = ReflectTest03.class.getResourceAsStream("classInfo.properties");
		try {
			pro.load(ins);
			String className = (String) pro.getProperty("className");
			System.out.println(className);
			Class cl1 = Class.forName(className);
			Object o = cl1.newInstance();
			System.out.println(o);

		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}finally {
			if (ins!=null) {
				try {
					ins.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}

	}

}
