package com.ben.java.core.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密工具类
 * 
 * @author ben xia
 * @date 2018年10月27日上午9:10:45
 */
public class MD5Utils {

	private static final String salt = "k9j92k9s1";

	public static String MD5(String str) {
		return DigestUtils.md5Hex(str);
	}

	public static String inputPassToFormPass(String inputPass) {
		String str = "" + salt.charAt(1) + salt.charAt(0) + inputPass + salt.charAt(8) + salt.charAt(6)
				+ salt.charAt(3);

		return MD5(str);
	}

	public static String formPassToDBPass(String formPass, String salt) {
		String str = "" + salt.charAt(1) + salt.charAt(0) + formPass + salt.charAt(8) + salt.charAt(6) + salt.charAt(3);
		return MD5(str);
	}

	public static String inputPassToDBPass(String inputPass, String salt) {
		return formPassToDBPass(inputPassToFormPass(inputPass), salt);
	}

	public static void main(String[] args) {
		System.out.println(inputPassToFormPass("123456"));
		System.out.println(formPassToDBPass("f1dc7747d76fae57e27f2c1767cce17e", "we23rg4wqdqew"));
		System.out.println(inputPassToDBPass("123456", "we23rg4wqdqew"));
	}
}
