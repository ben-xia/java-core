package com.ben.java.core.netio.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * int read(): 此方法是一个字节一个字节的读取数据到内存中,返回的int是字节的码值,当再也没有读取到数据时返回-1;
 * 
 * @author ben xia
 * @date 2018年7月21日
 *
 */
public class FileInputStreamTest01 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		String filePath = "F:\\test.txt";
		try {
			fis = new FileInputStream(filePath);
			int len1 = fis.read();
			int len2 = fis.read();
			int len3 = fis.read();
			int len4 = fis.read();
			int len5 = fis.read();
			int len6 = fis.read();
			int len7 = fis.read();
			int len8 = fis.read();
			int len9 = fis.read();

			System.out.println(len1);
			System.out.println(len2);
			System.out.println(len3);
			System.out.println(len4);
			System.out.println(len5);
			System.out.println(len6);
			System.out.println(len7);
			System.out.println(len8);
			System.out.println(len9);

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
