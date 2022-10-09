package com.ben.java.gof.structural_model.proxy.jdk;
/**
 * 目标对象
 * @author ben xia
 * @email  keeping1990@126.com
 * @date   2018年10月1日下午5:57:12
 * @version
 */
public class SomeServiceImpl implements SomeService {

	@Override
	public String doSome() {
		System.out.println(">>>>>>>>>执行了目标方法"  );
		return "123";
	}

}
