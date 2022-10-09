package com.ben.java.core.netio.io;

import java.io.*;

public class BufferedReaderTest02 {

	public static void main(String[] args) {

		try {
			// FileInputStream fis = new FileInputStream("F:\\test.txt");
			// 转换流 InputStreamReader: 将字节流装换成字符流
			// 转换流OutputStreamWriter: 将字符流装换成字节流
			// InputStreamReader isr = new InputStreamReader(fis);
			// BufferedReader br = new BufferedReader(isr);
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\test.txt")));
			String temp = null;
			while ((temp = br.readLine()) != null) {
				System.out.println(temp);
			}
			;

			br.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
