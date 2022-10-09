package com.ben.java.gof.structural_model.proxy.cglib;

/**
 * 目标类
 */
public class SomeService {

	public String doSome() {
		System.out.println("业务类");
		return "abc";
	}
}
