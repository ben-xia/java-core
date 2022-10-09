package com.ben.java.gof.structural_model.decorator;

/**
 * 装饰者模式
 * 
 * @author ben xia
 * @date 2018年7月22日
 *
 */
public class DecoratorTest01 {

	public static void main(String[] args) {
		A a = new B();
		a.m1();

	}

}

class A {
	public void m1() {
		System.out.println("父类M1()方法执行");
	};
}

class B extends A {
	@Override
	public void m1() {
		System.out.println("子类M1()方法执行");
		super.m1();
		System.out.println("子类M1()方法执行");

	};
}
