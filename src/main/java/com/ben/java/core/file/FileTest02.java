package com.ben.java.core.file;

import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("E:\\Javaweb\\JavaSE");
		File[] files = f1.listFiles();
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
			
		}

	}

}
