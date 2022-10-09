package com.ben.java.core.netio.io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * DataOutputStream: 数据字节输出流,可以将内存中 "int i=10;"写入到硬盘文件中,写进去的不是字符串,而是二进制数据,带类型;
 * @author ben xia
 * @date   2018年7月22日
 *
 */
public class DataOutputStreamTest01 {

	public static void main(String[] args) {

		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("F:\\test.txt"));

			byte b = 1;
			short s = 2;
			int i = 3;
			long l = 1000L;
			float f = 3.12f;
			double d = 8.8809d;
			char c = 'a';
			boolean flag = false;

			dos.writeByte(b);
			dos.writeShort(s);
			dos.writeInt(i);
			dos.writeLong(l);
			dos.writeFloat(f);
			dos.writeDouble(d);
			dos.writeChar(c);
			dos.writeBoolean(flag);

			dos.flush();
			dos.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
