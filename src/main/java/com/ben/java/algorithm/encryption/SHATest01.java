package com.ben.java.algorithm.encryption;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA算法Secure Hash Algorithm(安全hash算法):安全散列算法(hash函数:将原始信息压缩,返回散列值),可以是SHA-1，
 * SHA1是目前最安全的摘要算法 摘要的长度为20字节,其他的SHA包括 SHA-256(32字节)
 * 
 * @author ben xia
 * @date 2018年10月6日上午10:07:01
 */
public class SHATest01 {
	public static void main(String[] args) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA");

			String s1 = "abc098";

			byte[] digest = messageDigest.digest(s1.getBytes());
			System.out.println(digest.length);

			String hexString = Hex.encodeHexString(digest);
			System.out.println(hexString);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

	}
}
