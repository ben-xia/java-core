package com.ben.java.gof.creative_mode.singleton;
/**
 * 静态内部类实现单例模式
 * @author ben xia
 * @date   2018年7月6日
 *
 */
public class Singleton02 {
	private static class SingletonHolder {
		public static Singleton02 instance = new Singleton02();
	}

	private Singleton02() {
	}

	public static Singleton02 getInstance() {
		return SingletonHolder.instance;
	}
}
