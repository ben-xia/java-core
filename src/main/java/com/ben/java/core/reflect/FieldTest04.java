package com.ben.java.core.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * java.lang.reflect.Field 类中的属性
 * @author ben xia
 * @date 2018年10月3日下午3:54:12
 */
public class FieldTest04 {

	public static void main(String[] args) throws Exception, SecurityException {

//		Class c1 = User.class;
		Class c1 = Integer.class;
		// Field declaredField = c1.getDeclaredField("id");
		// System.out.println(declaredField.getName());

		// 只能获取public修饰的属性
		// Field[] fields = c1.getFields();
		// System.out.println(fields.length);

		// 可以获取所有声明的属性
		Field[] declaredFields = c1.getDeclaredFields();
		// for (Field field : declaredFields) {
		// System.err.println(field.getModifiers());
		// System.out.println(Modifier.toString(field.getModifiers()));
		// Class<?> type = field.getType();
		// System.out.println(type.getName());
		// System.out.println(type.getSimpleName());
		// System.out.println(field.getName());
		// System.out.println("--------------------------");

		StringBuilder sb = new StringBuilder();
		sb.append(Modifier.toString(c1.getModifiers()) + " class " + c1.getSimpleName() + "{\n");
		for (Field field : declaredFields) {
			sb.append("\t" + Modifier.toString(field.getModifiers()) + " ");
			sb.append(field.getType().getSimpleName() + " ");
			sb.append(field.getName() + ";\n");
		}
		sb.append("}");
		System.out.println(sb.toString());

	}

}
