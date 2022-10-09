package com.ben.java.gof.creative_mode.singleton;
/**
 * 枚举单例: 缺点-占用太多的内存
 * 关于单例，我们总是应该记住：线程安全，延迟加载，序列化与反序列化安全，反射安全是很重重要的。
 * @author Administrator
 *
 */
public enum SingletonEnum {
	INSTANCE;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
