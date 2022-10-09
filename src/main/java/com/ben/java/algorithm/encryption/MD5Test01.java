package com.ben.java.algorithm.encryption;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5算法(Message Digest Algorithm 5)可以保证数据传输完整性和一致性,摘要后长度为16字节.
 * 摘要信息中不包含原文信息,所有加密结果不可逆(无法解密),一般在传送文件时,对源文件进行md5 hash,传送到对方后,检测hash值是否相等
 * 如果相等,文件传输正确,如果不相等,说明文件被篡改（加入木马）或者未传送完成
 *
 * @author ben xia
 * @date 2018年10月6日上午10:04:30
 */
public class MD5Test01 {

    public static void main(String[] args) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");

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
