package com.ben.java.core.netio.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 
 * 
 * @author ben xia
 * @date 2018年7月21日
 *
 */
public class FileInputStreamTest03 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		String filePath = "F:\\test.txt";
		try {
			fis = new FileInputStream(filePath);  //将文件读取到流中
			System.out.println(fis.available());  //8 估算流中未读进内存中的字节数
			System.out.println(fis.read());   //97
			System.out.println(fis.skip(2));  //2  跳过流中2个字节
			System.out.println(fis.read());  //100
			System.out.println(fis.available());  //4

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
