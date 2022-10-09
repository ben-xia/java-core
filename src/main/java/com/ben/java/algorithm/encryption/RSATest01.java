package com.ben.java.algorithm.encryption;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA算法:目前影响力最大的非对称加密算法,一般公钥对外公开,加密后传送给服务器,服务器使用独有的私钥解密
 * (当然也可以私钥加密,公钥解密,一般不这样,因为谁都有公钥都能解密,加密就没有意义了),加密的数据在传输过程是无法破解的,  
 * 秘钥对初始化大小必须是64的倍数 ,实际值只能在512-1024中
 * 
 * @author ben xia
 * @date 2018年10月6日上午10:19:28
 */
public class RSATest01 {

	public static void main(String[] args) throws Exception {
		// 生成RSA密钥对
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(512);
		KeyPair kp = kpg.generateKeyPair();
		PublicKey pk = kp.getPublic();
		PrivateKey prk = kp.getPrivate();
		// 公钥加密
		//cipher: 文件加密;密码
		Cipher cip = Cipher.getInstance("RSA");
		cip.init(Cipher.ENCRYPT_MODE, pk);
		byte[] mw = cip.doFinal("test".getBytes());
		// 私钥解密
		Cipher cip1 = Cipher.getInstance("RSA");
		cip1.init(Cipher.DECRYPT_MODE, prk);
		System.out.println(new String(cip1.doFinal(mw)));
	}

	/**
	 * * 读取公钥字节数组转换为对象
	 * 
	 * @throws Exception
	 */
	public PublicKey getPub(byte[] bt) throws Exception {
		X509EncodedKeySpec x = new X509EncodedKeySpec(bt);
		KeyFactory fac = KeyFactory.getInstance("RSA");
		return fac.generatePublic(x);
	}

	/**
	 * 读取私钥字节数组转换为对象
	 * 
	 * @throws Exception
	 */
	public PrivateKey getPri(byte[] bt) throws Exception {
		PKCS8EncodedKeySpec x = new PKCS8EncodedKeySpec(bt);
		KeyFactory fac = KeyFactory.getInstance("RSA");
		return fac.generatePrivate(x);
	}

}
