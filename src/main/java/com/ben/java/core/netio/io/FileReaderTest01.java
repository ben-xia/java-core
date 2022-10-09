package com.ben.java.core.netio.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {

	public static void main(String[] args) {

		try {
			String s = "";
			FileReader fr = new FileReader("F:\\test.txt");

			int temp = 0;
			char[] c = new char[1024];
			while ((temp = fr.read(c)) != -1) {
				s += (new String(c, 0, temp));
			}
			System.out.println("s====" + s);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
