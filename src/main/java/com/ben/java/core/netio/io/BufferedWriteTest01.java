package com.ben.java.core.netio.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteTest01 {

	public static void main(String[] args) {

		try {
			//带有缓冲区的字符输出流
			BufferedWriter br = new BufferedWriter(new FileWriter("F:\\test.txt",true));
			br.write("中国");
			br.newLine();
			br.write("美国");
			br.newLine();

			br.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
