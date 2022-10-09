package com.ben.java.core.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 创建与使用注解处理器[通过Reflect机制]
 * @author ben xia
 * @date   2018年10月4日上午11:20:44
 */
public class UseCaseTracker {

	public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
		

		for (Method m : cl.getDeclaredMethods()) {  //获取cl类声明的所有的方法
			UseCase uc = m.getAnnotation(UseCase.class);  //查找[方法上]指定的注解并返回
			if (uc != null) {
				System.out.println("Found Use Case" + uc.id() + " " + uc.description());
				useCases.remove(new Integer(uc.id()));
			}
		}
		for (Integer i : useCases) {
			System.out.println("Warning: Missing use case-" + i);
		}
	}

	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<>();
		Collections.addAll(useCases, 47,48,49,50);
		trackUseCases(useCases, PasswordUtils.class);
	}

}
