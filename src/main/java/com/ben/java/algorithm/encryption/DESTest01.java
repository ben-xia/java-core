package com.ben.java.algorithm.encryption;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * DES算法(Data Encryptin Standard)是对称加密算法的一种:使用秘钥加解密,秘钥必须是56字节        
 * 概念解释：
 * 秘钥:用于加密和解密的钥匙,秘钥可以使用 getEncoded方法获取byte[],存储在文件系统中           
 * 公钥和私钥：用于非对称加密的钥匙,公钥加密,私钥解密,私钥一般用于解密所以私钥一般存储在密钥库中           
 * 口令：一般是自定义的字符串,可以通过口令和盐生成秘钥 
 * 
 * @author ben xia
 * @date 2018年10月6日上午9:59:01
 */
public class DESTest01 {
	/** * 生成56字节的秘钥 */
	public static SecretKey genKey(int len) throws NoSuchAlgorithmException {
		KeyGenerator kg = KeyGenerator.getInstance("DES");
		kg.init(len);
		return kg.generateKey();
	}

	public static void main(String[] args) throws Exception {
		// SecretKey sk=new SecretKeySpec(kl.getBytes(), "DES");
		SecretKey sk = genKey(56);
		// ---------加密
		String password = "tiger";
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, sk);
		// 被加密之后获取的字节数组
		byte[] mcontent = cipher.doFinal(password.getBytes());
		System.err.println(new String(mcontent, "utf-8"));

		// ---------解密
		Cipher cipher1 = Cipher.getInstance("DES");
		cipher1.init(Cipher.DECRYPT_MODE, sk);
		System.out.println(new String(cipher1.doFinal(mcontent)));
	}

}
