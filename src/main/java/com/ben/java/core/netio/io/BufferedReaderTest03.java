package com.ben.java.core.netio.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 接收用户的输入 BufferedReader
 * 
 * @author ben xia
 * @date 2018年7月22日
 *
 */
public class BufferedReaderTest03 {

	public static void main(String[] args) {

		// 以前的方式
		// Scanner scanner = new Scanner(System.in);
		// //System.in:标准的输入流,默认接收的是键盘输入;System.out:标准的输出流,默认输出到控制台;

		// 程序执行到此处停下来了,等待用户的输入
		// String str = scanner.next();
		// System.out.println("您输入了:" + str);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = null;

		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
