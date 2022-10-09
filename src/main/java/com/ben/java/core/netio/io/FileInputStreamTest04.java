package com.ben.java.core.netio.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * int read(byte[] byte):读取之前在内存中准备一个byte数组,每次读取多个字节存储到byte数组中.
 * 即一次读取多个字节(而不是单字节读取了),返回的int类型代表的是这次读取了多少个字节到byte数组中, 当再也没有读取到数据时返回-1;
 * 
 * @author ben xia
 * @date 2018年7月21日
 *
 */
public class FileInputStreamTest04 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		String filePath = "F:\\test.txt";
		try {
			fis = new FileInputStream(filePath);
			// 准备一个byte数组,每一次最多读取3个字节
			byte[] b = new byte[5];
			StringBuilder sb = new StringBuilder();
			int len;
			while ((len = fis.read(b))!=-1) {
				sb.append(new String(b, 0, len));
			}
			System.out.println("sb===" + sb.toString());

		} catch (Exception e) {

			e.printStackTrace();
		} finally

		{

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

};
