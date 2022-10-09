package com.ben.java.algorithm.encryption;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * java.util.Base64  用于将字节数组和字符串互相转换
 * @author ben xia
 * @date   2018年10月5日下午6:22:25
 */
public class Base64Test01 {

	public static void main(String[] args) {

		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();

		String s = "abc123";
		String encodeToString = encoder.encodeToString(s.getBytes());

		System.out.println(encodeToString);
		
		
		
		try {
			String x = new String(decoder.decode(encodeToString), "utf-8");
			System.out.println(x);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}

	}

}
