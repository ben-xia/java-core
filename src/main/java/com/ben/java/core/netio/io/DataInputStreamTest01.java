package com.ben.java.core.netio.io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 电信行业应用
 * DataInputStream: 要使用该流读取数据,必须提前知道该文件中的数据的存储格式,顺序;
 * 					读的顺序必须和写入的顺序相同;
 * @author ben xia
 * @date   2018年7月22日
 *
 */
public class DataInputStreamTest01 {

	public static void main(String[] args) {

		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("f:\\test.txt"));
			byte b = dis.readByte();
			System.out.println(b);
			
			short s = dis.readShort();
			System.out.println(s);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
