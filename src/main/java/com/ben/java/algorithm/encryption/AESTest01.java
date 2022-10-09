package com.ben.java.algorithm.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * AES算法 （Advanced Encryptin Standard 高级加密标准)是对称加密算法一种升级,
 * 因为56位秘钥在计算机系统性能越来越高的前提下56位很容易被破解, 所以
 * AES将秘钥的长度提高到128,192,256,必须是这三个数,128默认可以使用,192和256由于美国限制, 需要相关授权,否则抛出异常
 * 
 * @author ben xia
 * @date 2018年10月6日上午9:54:40
 */
public class AESTest01 {
	public static final String AL = "AES";

	/** * 生成56字节的秘钥 */
	public static SecretKey genKey(int len) throws NoSuchAlgorithmException {
		KeyGenerator kg = KeyGenerator.getInstance(AL);
		kg.init(len);
		return kg.generateKey();
	}

	public static void main(String[] args) throws Exception {
		// SecretKey sk=new SecretKeySpec(kl.getBytes(), "DES");
		SecretKey sk = genKey(128);
		// ---------加密
		String password = "tiger";
		Cipher cipher = Cipher.getInstance(AL);
		cipher.init(Cipher.ENCRYPT_MODE, sk);
		// 被加密之后获取的字节数组
		byte[] mcontent = cipher.doFinal(password.getBytes());
		System.err.println(new String(mcontent, "utf-8"));
		// ---------解密
		Cipher cipher1 = Cipher.getInstance(AL);
		cipher1.init(Cipher.DECRYPT_MODE, sk);
		System.out.println(new String(cipher1.doFinal(mcontent)));
	}
}
