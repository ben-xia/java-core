package com.ben.java.core.reflect;

public class ReflectTest02 {

	public static void m1(Class... args) throws Exception {
		for (Class cl : args) {
			Object o = cl.newInstance();
			System.out.println(o);
		}
	}

	public static void main(String[] args) throws Exception {

		m1(java.util.Date.class);
	}

}
