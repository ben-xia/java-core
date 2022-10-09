package com.ben.java.gof.structural_model.decorator;

/**
 * 自定义类 使用BufferedReader对FileReader中的close方法进行扩展 
 * 1.装饰者模式中要求:装饰者中含有被装饰者的引用;
 * 2.装饰者模式中要求:装饰者和被装饰者应该实现同一个接口/类型;
 * 
 * @author ben xia
 * @date 2018年7月22日
 *
 */
public class BufferedReader extends Reader { // 装饰者
	private Reader reader; // 被装饰者

	public BufferedReader(Reader reader) {
		this.reader = reader;
	};

	@Override
	public void close() {
		System.out.println("BufferedReader.close()!!!");
		this.reader.close();
		System.out.println("BufferedReader.close()!!!");
	};

}
