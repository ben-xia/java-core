package com.ben.java.core.file;

import java.io.File;
import java.io.IOException;

public class FileTest01 {

	public static void main(String[] args) {
		File f1 = new File("f:/zz");   //如果不存在,不会自动创建
		
		if (!f1.exists()) {
			try {
				f1.createNewFile();  //创建文件;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
//			f1.mkdir();   //只能创建一层目录;
//			f1.mkdirs();   //可以递归的创建所有不存在的目录;
			
		}
		
		
	}
}
