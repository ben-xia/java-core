package com.ben.java.core.netio.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * string readLine() :此方法一次度一行,返回的是读取到的该行的字符串,但是行尾不带换行符;
 * 
 * @author ben xia
 * @date 2018年7月22日
 *
 */
public class BufferedReaderTest01 {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("F:\\test.txt"));
//			StringBuilder sb = new StringBuilder();
			
					String str = null;
					//string readLine() 返回的是读取到的该行的字符串
					while((str = br.readLine()) !=null) {
//						sb.append(str);
						System.out.println(str);
						
					};
//					System.out.println(sb.toString());
			
			//关闭流
			//注意:关闭的时候只需要关闭最外层的包装流(这里有一个装饰者模式)
			br.close();
			
			
			


		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
