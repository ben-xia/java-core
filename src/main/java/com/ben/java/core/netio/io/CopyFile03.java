package com.ben.java.core.netio.io;

import java.io.*;

/**
 * 文件复制
 * 
 * @author ben xia
 * @date 2018年7月21日
 *
 */
public class CopyFile03 {

	public static void main(String[] args) {

		FileInputStream fis = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		FileOutputStream fos = null;

		try {
			fis = new FileInputStream("F:\\test.txt");
			isr = new InputStreamReader(fis);
			fos = new FileOutputStream("D:\\test.txt", true);
			osw = new OutputStreamWriter(fos, "utf-8");

			char[] c = new char[1024];
			int temp = 0;

			while ((temp = isr.read(c)) != -1) {
				osw.write(c, 0, temp);

			}
			osw.flush();
			fos.flush();
			System.out.println("flush()");

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
