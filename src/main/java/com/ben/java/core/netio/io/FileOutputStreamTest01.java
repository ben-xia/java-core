package com.ben.java.core.netio.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {

	public static void main(String[] args) {

		FileOutputStream fos = null;
		try {
//			fos = new FileOutputStream("F:\\test.txt");//该文件不存在会自动的创建,如果已经存在则会覆盖已有数据
			fos = new FileOutputStream("F:\\test.txt",true);//该文件不存在会自动的创建,如果已经存在则会在之前的数据上追加数据
			
			String s1 = "HUAWEI + Google";   //程序本身就运行在内存中;
			byte[] bytes = s1.getBytes();
			for (int i = 0; i < 10; i++) {
				fos.write(bytes,0,5);
			}
			fos.flush();
			System.out.println("flush()");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} finally {

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
