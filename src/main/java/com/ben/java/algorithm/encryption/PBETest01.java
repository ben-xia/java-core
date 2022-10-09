package com.ben.java.algorithm.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.util.Random;

/**
 * PBE算法（Password Base Encryption） 基于自定义口令的加解密算法 定义口令 同时还必须定义 盐和 使用盐混淆的次数 加解密过程中
 * 该三个参数都必须一致
 * 
 * @author ben xia
 * @date 2018年10月6日上午9:53:43
 */
public class PBETest01 {
	// 盐 用于将明文进行多次混淆
	static byte[] salt = new byte[8];
	static Random r = new Random();
	static int saltCount = 100;
	static {
		r.nextBytes(salt);
	}
	public static final String AL = "PBEWithMD5AndDES";

	/** * 生成自定义口令的秘钥 */
	public static SecretKey genKey(String kl) throws Exception {
		char[] klChar = kl.toCharArray();
		PBEKeySpec pbe = new PBEKeySpec(klChar);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(AL);
		return skf.generateSecret(pbe);
	}

	/** * 使用口令和盐进行加密 */
	public static byte[] encrypt(SecretKey key, byte[] src) throws Exception {
		Cipher cipher = Cipher.getInstance(AL);
		// 使用口令 盐（100次混淆）
		PBEParameterSpec parameter = new PBEParameterSpec(salt, saltCount);
		cipher.init(Cipher.ENCRYPT_MODE, key, parameter);
		// 被加密之后获取的字节数组
		byte[] mcontent = cipher.doFinal(src);
		System.err.println(new String(mcontent,"utf-8"));
		return mcontent;
	}

	/** * 使用口令和盐进行解密 盐和口令和混淆的次数都必须和加密之前一致 */
	public static byte[] decrypt(SecretKey key, byte[] src) throws Exception {
		Cipher cipher = Cipher.getInstance(AL);
		// 使用口令 盐（100次混淆）
		PBEParameterSpec parameter = new PBEParameterSpec(salt, saltCount);
		cipher.init(Cipher.DECRYPT_MODE, key, parameter);
		// 被加密之后获取的字节数组
		byte[] mcontent = cipher.doFinal(src);
		return mcontent;
	}

	public static void main(String[] args) throws Exception {
		// SecretKey sk=new SecretKeySpec(kl.getBytes(), "DES");
		SecretKey sk = genKey("123456");
		// ---------加密
		String password = "tiger";
		byte[] mw = encrypt(sk, password.getBytes());
		// ---------解密
		System.out.println(new String(decrypt(sk, mw)));
	}
}
